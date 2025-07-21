import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Streaming {
  public static void writecsv(String file, String[] header, List<String[]> rows) {
    try(BufferedWriter wr = new BufferedWriter(new FileWriter(file))) {
    
    wr.write(String.join(",",header));
    wr.newLine();
    
    rows.stream()
        .map(row -> String.join(",",row))
        .forEach(line -> {
          try {wr.write(line);wr.newLine();}
          catch(IOException e) {e.printStackTrace();}
        });
    
      } catch(IOException e) {e.printStackTrace();}
  }
  public static void main(String[] args) {
    String rawdata = "Employee.csv";
    
    List<String[]> data = new ArrayList<>();
    
    try (BufferedReader rd = new BufferedReader(new FileReader(rawdata))) {
      String line;
      int cnt = 0;
      
      while ((line = rd.readLine()) != null && cnt <100) {
        String[] cols = line.split(",");
        String[] row = Arrays.copyOf(cols,Math.min(cols.length,6));
        data.add(row);
        cnt++;
      }
    } catch (IOException e) {e.printStackTrace();}
    
    String[] header =  data.get(0);
    List<String[]> body = data.subList(1,data.size());
    
    List<String[]> age30 = body.stream()
                               .filter(row -> {
                                try {
                                  return Integer.parseInt(row[4])>30;
                                } catch (NumberFormatException e) {return false;}
                               })
                               .collect(Collectors.toList());
    
    List<String> distinct = body.stream()
                                  .map(row -> row[2].trim())
                                  .filter(city -> !city.isEmpty())
                                  .distinct()
                                  .collect(Collectors.toList());
                                  
    System.out.println("Distinct Cities are:");
    distinct.forEach(System.out::println);
    
    List<String[]> citylist = body.stream()
                                  .sorted(Comparator.comparing(row -> row[2].trim()))
                                  .collect(Collectors.toList());
    
    System.out.println("No of Employees above 30 :"+age30.size());
    writecsv("Output.csv",header,age30);
    writecsv("Employee_100.csv",header,data);
    writecsv("Employee_city.csv",header,citylist);
    }
  
}

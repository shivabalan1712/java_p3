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
    String rawdata = "Employee_100_with_salary.csv";
    
    List<String[]> data = new ArrayList<>();
    //Fetching the first 100 employee data
    try (BufferedReader rd = new BufferedReader(new FileReader(rawdata))) {
      String line;
      int cnt = 0;
      
      while ((line = rd.readLine()) != null && cnt <100) {
        String[] cols = line.split(",");
        String[] row = Arrays.copyOf(cols,Math.min(cols.length,7));
        data.add(row);
        cnt++;
      }
    } catch (IOException e) {e.printStackTrace();}
    
    String[] header =  data.get(0);
    List<String[]> body = data.subList(1,data.size());
    //Finding employee above 30 yrs 
    List<String[]> age30 = body.stream()
                               .filter(row -> {
                                try {
                                  return Integer.parseInt(row[4])>30;
                                } catch (NumberFormatException e) {return false;}
                               })
                               .collect(Collectors.toList());
    System.out.println("No of Employees above 30 :"+age30.size());
    //finding the distinct cities
    // List<String> distinct = body.stream()
    //                               .map(row -> row[2])
    //                               .filter(city -> !city.isEmpty())
    //                               .distinct()
    //                               .collect(Collectors.toList());
                                  
    // System.out.println("Distinct Cities are:");
    // distinct.forEach(System.out::println);
    
    //Listing the distinct city
    List<String[]> citylist = body.stream()
                                  .sorted(Comparator.comparing(row -> row[2]))
                                  .collect(Collectors.toList());
    //Listing the count of the city                              
    Map<String, Long> citycount = body.stream()
                                      .filter(row -> row.length > 2 && ! row[2].trim().isEmpty())
                                      .collect(Collectors.groupingBy(row -> row[2], TreeMap::new, Collectors.counting()));
    System.out.println("Distinct City output: ");
    citycount.forEach((city,count) -> System.out.println(city + " : "+count));
    //Average salary per city                                  
    System.out.println("Average Salary per city :");
    Map<String, Double> avgcity = body.stream()
                                      .collect(Collectors.groupingBy(row -> row[2], Collectors.averagingDouble(row -> Double.parseDouble(row[7]))));
                                      
    avgcity.forEach((city,avg) -> System.out.println(city+" : "+avg));
    //anymatch by phd in pune
    boolean phdpune = body.stream()
                          .anyMatch(row -> row[2].equalsIgnoreCase("Pune") && row[0].equalsIgnoreCase("PHD"));
  
    System.out.println("PHD employee in pune : "+phdpune);
    //findFirst emp with salary above 1.8L
    Optional<String[]> empsal = body.stream()
                                    .filter(row -> Double.parseDouble(row[6])> 180000)
                                    .findFirst();
                                    
    empsal.ifPresent(emp -> System.out.println("First employee with salary above 1.8L :"+ Arrays.toString(emp)));
    
    //reduce
    OptionalDouble avgSalary = body.stream()
                                   .mapToDouble(row -> Double.parseDouble(row[6]))
                                   .average();
                                   
    System.out.println("Avg Salary of the employees :"+avgSalary);
    
    //max
    Optional<String[]> maxemp = body.stream()
                                    .max(Comparator.comparingDouble(row -> Double.parseDouble(row[7])));
                                    
    maxemp.ifPresent(emp -> System.out.println("Max salary of the employee :"+Arrays.toString(emp)));
    
    writecsv("Output.csv",header,age30);
    writecsv("Employee_100.csv",header,data);
    writecsv("Employee_city.csv",header,citylist);
    }
  
}

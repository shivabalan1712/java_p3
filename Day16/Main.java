import java.util.*;
import java.time.*;
import java.text.*;
//public String toString()
import java.time.format.DateTimeFormatter;

//public void setTime(long time)

//public int hashCode()

public class Main {
  public static void main(String[] args) {
    // Date mydate = new Date();
    // System.out.println("System data: "+mydate.toString() );
    
    // mydate.setTime(15680);
    
    // System.out.println("Time after setting "+mydate.toString());
    
    // int d = mydate.hashCode();
    // System.out.println("Amount "+d);

    // LocalDateTime now = LocalDateTime.now();
    // System.out.println("System date and time :"+now);

    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    // String formattednow = now.format(formatter);
    // System.out.println("Formatted :"+formattednow);

    // LocalDateTime customDate = LocalDateTime.of(2025,1,1,0,0,15);
    // System.out.println("Custom DateTime : "+customDate.format(formatter));

    // int hash = customDate.hashCode();
    // System.out.println("Hash code (Amount) :"+hash);

    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedNow = now.format(formatter);
    
    Date date = new Date();
    SimpleDateFormat formatTime = new SimpleDateFormat("hh.mmaa");
    String time = formatTime.format(date);
    
    System.out.println(formattedNow);

    LocalDateTime bday = LocalDateTime.of(2002,12,17,12,30);
    System.out.println(bday);

    LocalDateTime future = now.plusDays(15).plusHours(10);
    System.out.println(future.format(formatter));

    if(bday.isBefore(now)){
      System.out.println("Past");
    }

    int hash = bday.hashCode();
    System.out.println("Hash code : "+hash);

  }
}
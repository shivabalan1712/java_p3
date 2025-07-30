import java.util.*;
public class timing{

  public static void converting(String time) {
    String format;
    String[] arr = time.split(":");
    
    int hh = Integer.parseInt(arr[0]);
    if(hh>12){hh=hh-12;format = "PM";}
    else if(hh == 00){hh=12;format = "AM";}
    else if(hh==12){format = "PM";}
    else {format = "AM";}
    
    String hr,min,sec;
    hr=String.format("%02d",hh);
    min=arr[1];
    sec=arr[2];
    
    System.out.println("Time in 12-hour format : "+hr+":"+min+":"+sec+" "+format);
  }
  
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter time in 24H format ");
	  var time = sc.nextLine();
	  
	  converting(time);
	}
}

//utilized var and also converting time from 24h to 12h


import java.util.*;

interface Seatmgt {
	void showavail();
	void updateseats();
}

class Bus {
	protected String busno;
	protected String route;
	protected String bustype;
	protected int totalseats;
	
	public Bus(String busno, String route, String bustype, int totalseats) {
		this.busno = busno;
		this.route = route;
		this.bustype = bustype;
		this.totalseats = totalseats;
	}
	
	void showdetails() {
		System.out.println("\nBus number : "+busno+"\nRoute : "+route+"\nBus Type : " +bustype+"\nAvailable Seats : "+totalseats);
	}
}

class Booking extends Bus {
	protected String passengername;
	protected int bookedseats;
	
	public Booking(String busno,String route, String bustype, int totalseats) {
		super(busno,route,bustype,totalseats);
	}
	
	void bookticket(String passengername, int seats) {
		if(seats <= totalseats) {
			this.passengername = passengername;
			this.bookedseats = seats;
			totalseats -= seats;
			System.out.println("Ticket booked");
		}
		else {
			System.out.println("Seats unavailable");
		}
	}
}

class Payment extends Booking implements Seatmgt {
	public Payment(String busno,String route, String bustype, int totalseats) {
		super(busno,route,bustype,totalseats);
	}
	
	public void makepayment(double amount) {
		System.out.println("Paid successfully "+amount+" for "+passengername);
	}
	
	public void showavail() {
		System.out.println("Available Seats : "+totalseats);
	}
	
	public void updateseats() {
		System.out.println("Seats updated : "+totalseats);
	
	}
}

public class Busbooksys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter bus number : ");
		String busno = sc.nextLine();
		System.out.println("Enter bus Route : ");
		String route = sc.nextLine();
		System.out.println("Enter Bus Type : ");
		String bustype = sc.nextLine();
		System.out.println("Enter no of seats : ");
		int seats = sc.nextInt();
		
		Payment bk = new Payment(busno,route,bustype,seats);
			
		int number;
		
		do{
			System.out.println("====Bus Booking System====\n1.View Bus Detalis\n2.Check Seat Avail\n3.Book Ticket\n4.Make Payment\n5.Exit\nEnter Your Choice : ");
			number = sc.nextInt();
			
			
			switch(number){
			  case 1: 
			    bk.showdetails();
			    break;
			  case 2:
			    bk.showavail();
			    break;
			  case 3:
			    sc.nextLine();
			    System.out.println("Enter Passenger name : ");
			    String name = sc.nextLine();
			    System.out.println("Enter No.of seats to book :");
			    int bookseats = sc.nextInt();
			    bk.bookticket(name,bookseats);
			    bk.updateseats();
			    break;
			  case 4:
			    System.out.println("Enter Payment Amount : ");
			    double amount = sc.nextDouble();
			    bk.makepayment(amount);
			    break;
			  case 5:
			    System.out.println("***Thanking You***");
			    break;
			  default :
			     System.out.println("Enter only valid options...");
			}
		}while(number != 5);
		sc.close();
	}
}

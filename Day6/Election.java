import java.io.*;
import java.util.*;

class Ageexcp extends Exception {
	public Ageexcp(String m) {
		super(m);
	}
}

class Stringexcp extends Exception {
  public Stringexcp(String m) {
    super(m);
  }
}

class Pinexcp extends Exception {
  public Pinexcp(String m) {
    super(m);
  }
}


public class Election {
	public void valid(int age) throws Ageexcp {
		if (age < 18) {
			throw new Ageexcp("You are not eligible to Vote ");
		}
		else {
			System.out.println("You are eligible to Vote ");
		}
	}
		
	public void strvalid(String name) throws Stringexcp {
		  if (!name.matches("[a-zA-Z]+")) {
		    throw new Stringexcp("Please enter only Alphabets");
		  }
	}
	
	public void pinvalid(int pin) throws Pinexcp {
	  String pinstring = String.valueOf(pin); 
	  if (!pinstring.matches("\\d{6}")) {
	    throw new Pinexcp("Pin number should be strictly 6 digits");
	  }
	}
		
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Election e = new Election();
			try {	
			  System.out.println("Enter Elector's Name : ");
			  String name = sc.nextLine();
			  e.strvalid(name);
				
				System.out.println("Enter Elector's Age : ");
				int userage = sc.nextInt();
				e.valid(userage);
				sc.nextLine();
				
				System.out.println("Enter Father's name :");
				String fname = sc.nextLine();
				e.strvalid(fname);
				
				System.out.println("Enter Address : ");
				String addr = sc.nextLine();
				
				System.out.println("Enter PINCODE :");
				int pincode = sc.nextInt();
				e.pinvalid(pincode);
				sc.nextLine();
				
				System.out.println("Enter Taluk : ");
				String taluk = sc.nextLine();
				
				System.out.println("==== Voter Id ==== \nElector's Name          :"+name+"\nElector's Father's name :" + fname + "\nAge                     :" + userage + "\nAddress                 :" + addr + "\nPincode                 :" + pincode + "\nTaluk                   :" + taluk);
								
				
			} catch (Ageexcp exp) {
				System.out.println("Exception Caught : "+exp.getMessage()+"\nWait until 18 to Vote...");
			} catch (Stringexcp exp) {
			  System.out.println("Exception Caught : "+exp.getMessage());
			} catch (Pinexcp exp) {
			  System.out.println("Exception Caught : "+exp.getMessage());
			}
		}
	
}

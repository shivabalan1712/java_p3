import java.util.*;

class Invalidexp extends Exception {
    public Invalidexp(String m) {
        super(m);
    }
}

public class pos {

  static String[] items = {"Apple","Banana","Carrot","Drumstick","Egg plant"};
  
  static void display() {
    System.out.println("Available Items are : ");
	      for (int i = 0; i<items.length;i++) {
	        System.out.println(i+" "+items[i]);
	      }
	  }
  
  static void valid(int qty, double mrp,double sp) throws Invalidexp {
    if (qty <= 0) throw new Invalidexp("Quantity must be greater than zero");
    if (sp > mrp) throw new Invalidexp("Selling Price cant be greater than the MRP");
    if (mrp <=0 || sp <=0) throw new Invalidexp("Price  must be greater than zero");
  }
  
	public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  
	  double grandtotalmrp = 0;
	  double grandtotalsp = 0;
	  
	  try {
	    System.out.println("Welcome to SHIVA SUPERMARKET");
	    
	    boolean addItem = true;
	    
	    while(addItem) {
	      display();
	      System.out.print("\nEnter item Number : ");
	      int choice = sc.nextInt();
	      String item = items[choice];
	    
	      System.out.println("\nEnter quantity  :");
	      int qty = sc.nextInt();
	    
	      System.out.println("\nEnter MRP per Unit :");
	      double mrp = sc.nextDouble();
	    
	      System.out.println("\nEnter SP per Unit :");
	      double sp = sc.nextDouble();
	    
	      valid(qty,mrp,sp);
	    
	      double totalmrp = qty * mrp;
	      double totalsp = qty * sp;
	      double savings = totalmrp - totalsp;
	      
	      grandtotalmrp += totalmrp;
	      grandtotalsp += totalsp;
	      
	      System.out.println("------------------------------");
	      System.out.println("Item      : "+item);
	      System.out.println("Quantity  : "+qty);
	      System.out.println("MRP/unit  : "+mrp);
	      System.out.println("SP/unit   : "+sp);
	      System.out.println("Total MRP : "+totalmrp);
	      System.out.println("Total SP  : "+totalsp);
	      System.out.println("Savings   : "+savings);
	      System.out.println("------------------------------");
	      
	      System.out.println("Do you want to add items : ");
	      int addon = sc.nextInt();
	      if(addon == 0) 
	        addItem = false;
	      }
	      System.out.println("\n==== Grand Total ====");
	      System.out.println("Total MRP     :"+grandtotalmrp);
	      System.out.println("Amount Paid   :"+grandtotalsp);
	      System.out.println("Total Savings :"+(grandtotalmrp-grandtotalsp));
	      
	      }catch (ArrayIndexOutOfBoundsException e) {
	          System.out.println("Exception : Item doesnot Exist");
	      }catch (NumberFormatException e) {
	          System.out.println("Exception : Enter only valid Input");
	      }catch (Invalidexp e) {
	          System.out.println("Exception : "+e.getMessage());
	      }catch (Exception e) {
	          System.out.println("Exception : "+e.getMessage());
	      } finally {System.out.println("***Thanking You***");}
	  }
	}



import java.util.*;

class Invalidexp extends Exception {
    public Invalidexp(String m) {
        super(m);
    }
}

class Inventoryexp extends RuntimeException {
    public Inventoryexp(String m) {
        super(m);
    }
}

public class pos {

    static String[] items = {"Apple", "Banana", "Carrot", "Drumstick", "Egg plant"};
    static int[] stock = {150, 100, 40, 10, 50};

    static void display() {
        System.out.println("==== Available Items ====");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " - " + items[i] + " (Qty: " + stock[i] + ")");
        }
    }

    static void validate(int qty, double mrp, double sp) throws Invalidexp {
        if (qty <= 0) throw new Invalidexp("Quantity must be greater than zero");
        if (mrp <= 0 || sp <= 0) throw new Invalidexp("Price must be greater than zero");
        if (sp > mrp) throw new Invalidexp("Selling Price cannot be greater than MRP");
    }

    static void checkInventory(int item, int qty) {
        if (item < 0 || item >= stock.length)
            throw new ArrayIndexOutOfBoundsException("Invalid item selection");

        if (stock[item] < qty)
            throw new Inventoryexp("Requested quantity exceeds available stock for " + items[item]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<String> purchasedItems = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Double> mrps = new ArrayList<>();
        List<Double> sps = new ArrayList<>();
        List<Double> totals = new ArrayList<>();

        double grandMrp = 0;
        double grandSp = 0;

        try {
            System.out.println("Welcome to Reliance Fresh");
            System.out.print("Enter number of different items to purchase: ");
            int itemCount = sc.nextInt();

            while (itemCount > 0) {
                display();
                System.out.print("\nEnter item number : ");
                int choice = sc.nextInt();

                System.out.print("Enter quantity : ");
                int qty = sc.nextInt();
                checkInventory(choice, qty);

                System.out.print("Enter MRP per unit: Rs.");
                double mrp = sc.nextDouble();

                System.out.print("Enter SP per unit : Rs.");
                double sp = sc.nextDouble();

                validate(qty, mrp, sp);

                double total = qty * sp;
                grandMrp += qty * mrp;
                grandSp += total;

                stock[choice] -= qty;

                purchasedItems.add(items[choice]);
                quantities.add(qty);
                mrps.add(mrp);
                sps.add(sp);
                totals.add(total);

                itemCount--;

                System.out.println("Item added successfully!\n");
            }


            System.out.println("\n=======================================================");
            System.out.println("                     Reliance Fresh         ");
            System.out.println("          123, Anna Nagar, Chennai-600040.\n");
            System.out.println("                      Purchase Bill         ");
            System.out.println("=======================================================");
            System.out.printf("%-9s %-10s %-5s %-8s %-8s %-9s\n","S.no", "Item", "Qty", "MRP", "SP", "Total");
            System.out.println("------------------------------------------------------\n");
            for (int i = 0; i < purchasedItems.size(); i++) {
                System.out.printf("%-9d%-10s %-5dRs.%-7.2fRs.%-7.2fRs.%-7.2f\n",i, purchasedItems.get(i), quantities.get(i), mrps.get(i), sps.get(i), totals.get(i));
            }

            System.out.println("\n------------------------------------------------------");
            System.out.println("Total Items Sold     : " + purchasedItems.size());
            System.out.println("Total Price Paid     : " + grandSp);
            System.out.println("You Have Saved       : " + (grandMrp - grandSp));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Invalid item selection");
        } catch (InputMismatchException e) {
            System.out.println("Exception: Please enter valid numeric inputs");
        } catch (Invalidexp | Inventoryexp e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("\n=======================================================");
            System.out.println("                       Thanking You         ");
            System.out.println("                      Visit Again !!!       ");
            System.out.println("=======================================================");
        }
    }
}
//placeholders
//% 5 s - string
//% 5 d - int
//% 6.2 f - float with 2 decimals


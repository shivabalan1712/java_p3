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

class Inventory {
    static String[] items = {"Apple", "Banana", "Orange", "Grapes", "Pomegranate"};
    static int[] stock = {150, 100, 140, 100, 150};
    static double[] mrplist = {150, 20, 50, 80, 120};
}

class User extends Inventory {
    public void Bill(String customerName, String mobileNumber, String receiptNumber, List<String> purchasedItems, List<Integer> quantities, List<Double> mrps, List<Double> sps, List<Double> totals, double grandMrp, double grandSp) {
        System.out.println("\n=======================================================");
        System.out.println("                     Reliance Fresh         ");
        System.out.println("          123, Anna Nagar, Chennai-600040.\n");
        System.out.println("                      Purchase Bill         ");
        System.out.println("------------------------------------------------------\n");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Receipt Number: " + receiptNumber);
        System.out.println("=======================================================");
        System.out.printf("%-9s %-10s %-5s %-8s %-8s %-9s\n", "S.no", "Item", "Qty", "MRP", "SP", "Total");
        System.out.println("------------------------------------------------------\n");
        for (int i = 0; i < purchasedItems.size(); i++) {
            System.out.printf("%-9d%-10s %-5dRs.%-7.2fRs.%-7.2fRs.%-7.2f\n",i + 1, purchasedItems.get(i), quantities.get(i), mrps.get(i), sps.get(i), totals.get(i));
        }

        System.out.println("\n------------------------------------------------------");
        System.out.println("Total Items Sold     : " + purchasedItems.size());
        System.out.println("Total Price Paid     : Rs." + grandSp);
        System.out.println("You Have Saved       : Rs." + (grandMrp - grandSp));
        System.out.println("\n=======================================================");
        System.out.println("                       Thanking You         ");
        System.out.println("                      Visit Again !!!       ");
        System.out.println("=======================================================\n");
    }
}

class Manager extends Inventory {
    protected void ItemsSold(List<String> items, List<Integer> qty) {
        System.out.println("\n==== Manager's Summary ==== ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i) + " - Qty: " + qty.get(i));
        }
    }
}

class Owner extends Inventory {
    private void Summary(List<String> items, List<Integer> qty, double totalcp, double totalsp) {
        System.out.println("\n ==== Owner's Report ====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i) + " - Qty: " + qty.get(i));
        }
        System.out.println("Total Cost Price     : Rs." + totalcp);
        System.out.println("Total Selling Price  : Rs." + totalsp);
        System.out.println("Total Profit         : Rs." + (totalsp - totalcp));
    }

    public void showSummary(List<String> items, List<Integer> qty, double totalcp, double totalsp) {
        Summary(items, qty, totalcp, totalsp);
    }
}

public class Shopping extends Inventory {
    private static int rno = 1;

    static void checkInventory(int item, int qty) {
        if (item < 0 || item >= stock.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid item number");
        }
        if (stock[item] < qty) {
            throw new Inventoryexp("Item out of stock");
        }
    }

    static void validate(int qty) throws Invalidexp {
        if (qty <= 0) throw new Invalidexp("Quantity must be greater than 0");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();
        String receiptNumber = "Rno." + rno++;

        List<String> purchasedItems = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Double> mrps = new ArrayList<>();
        List<Double> sps = new ArrayList<>();
        List<Double> cps = new ArrayList<>();
        List<Double> totals = new ArrayList<>();

        double grandMrp = 0;
        double grandSp = 0;
        double totalCp = 0;

        try {
            System.out.println("\nWelcome to Reliance Fresh");
            System.out.print("\nEnter number of different items to purchase: ");
            int itemCount = sc.nextInt();

            while (itemCount > 0) {
                System.out.println("\n==== Available Items ====");
                for (int i = 0; i < items.length; i++) {
                    System.out.println(i + " - " + items[i] + " | Qty: " + stock[i] + " | MRP: Rs." + mrplist[i]);
                }

                int choice = -1;
                int qty = -1;

                while (true) {
                    try {
                        System.out.print("\nEnter item number: ");
                        choice = sc.nextInt();
                        System.out.print("Enter quantity: ");
                        qty = sc.nextInt();
                        validate(qty);
                        checkInventory(choice, qty);
                        break; 
                    } catch (Invalidexp | Inventoryexp | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage() + " – Please re-enter.\n");
                        sc.nextLine(); 
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Enter valid numeric input – Please re-enter.\n");
                        sc.nextLine(); 
                    }
                }

                double mrp = mrplist[choice];
                double sp = mrp * 0.9;
                double cp = mrp * 0.8;
                double total = qty * sp;

                stock[choice] -= qty;

                purchasedItems.add(items[choice]);
                quantities.add(qty);
                mrps.add(mrp);
                sps.add(sp);
                cps.add(cp);
                totals.add(total);

                grandMrp += qty * mrp;
                grandSp += total;
                totalCp += qty * cp;

                itemCount--;
                System.out.println("Item added successfully!");
            }

            User customer = new User();
            customer.Bill(customerName, mobileNumber, receiptNumber,
                    purchasedItems, quantities, mrps, sps, totals, grandMrp, grandSp);

            Manager manager = new Manager();
            manager.ItemsSold(purchasedItems, quantities);

            Owner owner = new Owner();
            owner.showSummary(purchasedItems, quantities, totalCp, grandSp);

        } catch (Exception e) {
            System.out.println("Unexpected Exception: " + e.getMessage());
        } finally {
            System.out.println("\n**** Thanking You ****");
        }
    }
}


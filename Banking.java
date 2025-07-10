import java.util.*;

public class Banking {

    static class Account {
        String accno;
        String accname;
        double balance;

        public Account(String accno, String accname, double balance) {
            this.accno = accno;
            this.accname = accname;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited Rs." + amount);
                System.out.println("Current Balance: Rs." + balance);
            } else {
                System.out.println("Deposit Failed. Amount must be positive.");
            }
        }

        public void withdraw(double amt) {
            if (amt > 0 && balance >= amt) {
                balance -= amt;
                System.out.println("Withdrawal of Rs." + amt + " success.");
                System.out.println("Current Balance: " + balance);
            } else if (amt <= 0) {
                System.out.println("Enter only positive values.");
            } else {
                System.out.println("Insufficient Balance.");
            }
        }

        public double getBal() {
            return balance;
        }

        public String getAccinfo() {
            return "Account Number: " + accno + ", Account Holder Name: " + accname + ", Balance: " + balance;
        }

        public String getAccno() {
            return accno;
        }
    }

    static class Bank {
        public List<Account> accounts;

        public Bank() {
            this.accounts = new ArrayList<>();
        }

        public void addAccount(Account account) {
            accounts.add(account);
            System.out.println("Account Created Successfully");
        }

        public Account findAccount(String accno) {
            for (Account account : accounts) {
                if (account.getAccno().equals(accno)) {
                    return account;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        do {
            System.out.println("\n====== Bank ====== \n 1. Create Account \n 2. Deposit \n 3. Withdraw \n 4. View Account \n 5. Exit \n Enter your Choice : ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accName = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initBal = sc.nextDouble();
                    sc.nextLine(); 
                    Account acc = new Account(accNo, accName, initBal);
                    bank.addAccount(acc);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAccNo = sc.nextLine();
                    Account depAcc = bank.findAccount(depAccNo);
                    if (depAcc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        sc.nextLine(); 
                        depAcc.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withAccNo = sc.nextLine();
                    Account withdrawAcc = bank.findAccount(withAccNo);
                    if (withdrawAcc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        sc.nextLine(); 
                        withdrawAcc.withdraw(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String infoAccNo = sc.nextLine();
                    Account infoAcc = bank.findAccount(infoAccNo);
                    if (infoAcc != null) {
                        System.out.println("Account Found!");
                        System.out.println(infoAcc.getAccinfo());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("*** Thanking you! ***");
                    break;

                default:
                    System.out.println("Enter a valid option only ...");
            }

        } while (choice != 5);

        sc.close();
    }
}

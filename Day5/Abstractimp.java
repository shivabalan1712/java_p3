abstract class BankAccount {
	String name;
	double balance;
	
	BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	void deposit(double amount) {
		balance+=amount;
		System.out.println("Current balance : " + balance);
	}
	
	void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			System.out.println("Transaction Successful !\nCurrent Balance : " + balance);
		}
		else {
			System.out.println("Insufficient Fund...");
		}
	}
	
	abstract void interest();
}

class SavingsAccount extends BankAccount {
	SavingsAccount(String name, double balance) {
		super(name,balance);
	}
	
	void interest() {
		double interest = balance * 0.05;
		System.out.println("Savings Interest : "+ interest);
	}
}

class CurrentAccount extends BankAccount {
	CurrentAccount(String name, double balance) {
		super(name,balance);
	}
	
	void interest() {
		double interest = balance * 0.05;
		System.out.println("Current Interest : "+ interest);
	}
}

public class Abstractimp {
	public static void main(String[] args) {
		BankAccount shiva = new SavingsAccount("Shiva",100000);
		BankAccount balan = new CurrentAccount("Balan",200000);
		
		shiva.deposit(2000);
		shiva.interest();
		
		balan.withdraw(3000);
		balan.interest();
	}
}


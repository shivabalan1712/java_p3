abstract class Vehicle {
	String brand;
	
	Vehicle(String brand) {
		this.brand = brand;
		System.out.println("Vehicle is from :"+ brand);
	}
	
	abstract void start();
	
	void fuel() {
		System.out.println("Fuel type is Petrol");
	}
}

class Bike extends Vehicle {
	Bike(String brand) {
		super(brand);
		System.out.println(brand +" bike new Model");
	}
	
	void start() {
	  System.out.println("Bike Started");
	}
}

public class Access {
	public static void main(String[] args) {
		Vehicle scooter = new Bike("Suzuki");
		
		scooter.start();
		scooter.fuel();
	}
}

abstract class Car implements Vehicle {
	abstract void type();
	public void start() {
		System.out.println("Car Started");
	}
	public void stop() {
		System.out.println("Car Stopped");
	}
}

class Bike extends Car{ //abstract class called using the sub class
  void type() {
		System.out.println("Type of the vehicle");
	}
}

public class Abstvehicle {
	
	public static void main(String[] args) {
		Bike obj = new Bike();
		obj.start();
		obj.stop();
		obj.type();
	}
}


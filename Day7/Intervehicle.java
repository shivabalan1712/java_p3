class Car implements Vehicle {
	public void start() {
		System.out.println("Car Started");
	}
	public void stop() {
		System.out.println("Car Stopped");
	}
}

public class Intervehicle {
	public static void main(String[] args) {
		Car obj = new Car();
		obj.start();
		obj.stop();
	}
}


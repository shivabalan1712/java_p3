import java.util.*;

class Vehicle {
    void type() {
        System.out.println("General Vehicle (parent class)");
    }
}


class LightVehicle extends Vehicle {
    void type() {
        System.out.println("Light Vehicle (child class a)");
    }
}

class HeavyVehicle extends Vehicle {
    void type() {
        System.out.println("Heavy Vehicle (child class b)");
    }
}


class TwoWheeler extends LightVehicle {
    void type() {
        System.out.println("Two-Wheeler: Bike, Scooter(child class a's child 1)");
    }
}

class FourWheeler extends LightVehicle {
    void type() {
        System.out.println("Four-Wheeler: Sedan, SUV, Coupe (child a's child 2)");
    }
}


class SixWheeler extends HeavyVehicle {
    void type() {
        System.out.println("Six-Wheeler:Truck, Leyland(child b's child 1)");
    }
}

public class Automobile {
    public static void main(String[] args) {
        Vehicle general = new Vehicle();
        Vehicle light = new LightVehicle();
        Vehicle heavy = new HeavyVehicle();
        Vehicle bike = new TwoWheeler();
        Vehicle car = new FourWheeler();
        Vehicle truck = new SixWheeler();


        System.out.println("====Vehicle Types===");
        general.type();      
        light.type();      
        heavy.type();        
        bike.type();        
        car.type();         
        truck.type();       
    }
}


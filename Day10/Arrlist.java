import java.util.*;

public class Arrlist {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Mango");  
        System.out.println("Original list: " + fruits);

        fruits.remove("Mango");  
        fruits.add(1, "Orange"); 
        fruits.set(0, "Pineapple"); 

        System.out.println("Updated list: " + fruits);
        System.out.println("Contains Banana? " + fruits.contains("Banana"));
        System.out.println("Size: " + fruits.size());

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        Collections.sort(fruits);
        System.out.println("Sorted list: " + fruits);
    }
}


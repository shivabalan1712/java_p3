import java.util.*;


public class ArrayListEx {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("banana");
		
		System.out.println("Fruit at index 1: " +fruits.get(1));
		
		fruits.remove("banana");
		System.out.println(fruits);
	}
}

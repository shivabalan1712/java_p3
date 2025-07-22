import java.util.*;

public class hashing{
	public static void main(String[] args) {
		Map<String, Integer> hashmap = new HashMap<>();
		hashmap.put("Apple",1);
		hashmap.put("Banana",2);
		hashmap.put(null,3);
		System.out.println(hashmap);
		
		Map<String,Integer> linked = new LinkedHashMap<>();
		linked.put("Apple",1);
		linked.put("Banana",2);
		linked.put(null,3);
		System.out.println(linked);
		
		
	}
}

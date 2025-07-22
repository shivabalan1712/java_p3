import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Streaming {
	public static void main(String[] args) {
		//finding largest element in the string
		String s = "I am Learning java with Stream API";
		
		String ans = Arrays.stream(s.split(" "))
		      		         .max(Comparator.comparing(String::length)).get();
		      
		System.out.println(ans);
		//remove duplicates in the string and return in the same order
		String s1 = "dabcadefg";
		
		//s1.chars().distinct().mapToObj(x->(char)x).forEach(System.out::print);
		
		Arrays.stream(s1.split("")).distinct().forEach(System.out::print);
		//common elements- who all are resides in chennai
		//findanymatch
		//hash map,linked,concurrent
		//find the repeated characters
		String s2 = "Hello World";
		
		Map<Character, Long> charmap = s2.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		System.out.println(charmap);
		//string with max frequency
		String s3 = "Shivabalank";
		Map.Entry<Character, Long> ch = s3.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .orElse(null);
		           
		           
		System.out.println(ch.getKey() +":"+ ch.getValue());
	}
}

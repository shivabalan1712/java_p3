import java.util.*;
import java.io.*;

public class FileSearch {
	public static void main(String[] args) {
	
	  String filename = "News.txt";
	  
	  Set<String> dwords = new HashSet<>();
	  Map<String, Integer> wordCount = new HashMap<>();
	  int empty = 0;
	  
		try(BufferedReader rd = new BufferedReader(new FileReader(filename))){
			String line;
			while((line = rd.readLine()) != null){
			  if(line.trim().isEmpty()) {
			    empty++;
			    continue;
			  }
			  
			  String[] words = line.toLowerCase().split("\\W+");
			  
			  for (String word : words) {
			    if(! word.isEmpty()) {
			      dwords.add(word);
			      wordCount.put(word,wordCount.getOrDefault(word,0)+1);
			    }
			  }
			}
			
			System.out.println("Distinct words :");
			for (String word : dwords) {
			  System.out.print(word+ " ");
			}
			
			System.out.println("\n Common Words :");
			for (Map.Entry<String,Integer> entry :wordCount.entrySet()) {
			  if(entry.getValue()>1) {
			    System.out.println(entry.getKey() + "->"+entry.getValue() + "times");
			  }
			}
			
			System.out.println("\nNumber of Empty Lines :"+empty);
		} catch (IOException e) {
		  System.out.println("Error reading File :"+e.getMessage());
		}
	}
}

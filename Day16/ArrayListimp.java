import java.util.*;

import java.util.stream.*;

public class ArrayListimp {
  //normal sorting
  public static void sorting(String[] arr) {
    Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
  }
  //using compare To bubble sorting
  public static void sortingwithout(String arr[]) {
    for(int i=0;i<arr.length-1;i++){
		  for(int j=0;j<arr.length-1;j++) {
		    if(arr[j].compareTo(arr[j+1])>0) {
		      String temp = arr[j];
		      arr[j]=arr[j+1];
		      arr[j+1]=temp;
		    }
		  }
		}
		System.out.println(Arrays.toString(arr));
  }
  //group the words using first letter
  public static void groupbychar(String[] arr){
    Map<Character,List<String>> group =  Arrays.stream(arr)
            .collect(Collectors.groupingBy(w->Character.toUpperCase(w.charAt(0))));
            
    group.forEach((ch,list)->{System.out.println(ch+"->"+list);});
  }
  //search for a string in array
  public static void search(String[] arr,String str) {
    boolean result = Arrays.asList(arr).contains(str);
    System.out.println(result);
  }
  //remove duplicate in the array
  public static void duplicate(String[] arr){
    Set <String> newarr = new LinkedHashSet<>(Arrays.asList(arr));
    System.out.println(newarr);
  }
  //remove duplicates in array without using set
  public static void duplicatewithout(String[] arr){
    List<String> newarr = new ArrayList<>();
    
    for(String str : arr){
      if(!newarr.contains(str)) {
        newarr.add(str);
      }
    }
    System.out.println(newarr);
  }
  //remove duplicate in array using map
  public static void duplicateusingmap(String[] arr) {
    Map<String,Boolean> found = new LinkedHashMap<>();
    
    for (String str : arr){
      if(!found.containsKey(str)) {
        found.put(str,true);
      }
    }
    System.out.println(found);
  }
  //main
	public static void main(String[] args) {
		// List<String> names = new ArrayList<>(20);
		
		// names.add("Shiva");
		// names.add("Balan");
		// names.add("Ram");
		// //O(1) O(n)
		// System.out.println("Original List :"+names);
		
		// names.add(1,"Vetrivel");
		// System.out.println("Altered List :"+names);
		
		// names.remove("Ram");
		// System.out.println("After remove :"+names);
		
		// ArrayList<Integer> list = new ArrayList<>();
		
		// for(int i=0;i<=20;i++) {
		//   list.add(i);
		//   System.out.println("Added :"+i+", Size :"+list.size());
		// }
		
		// System.out.println("Final List :"+list);
		
		// ArrayList<Integer> largelist = new ArrayList<>(1000);
		
		// for(int j=0;j<1000;j++) {
		//   largelist.add(j);
		//   if(j==50){break;}
		// }
		// System.out.println("List size :"+largelist.size());
		
		String[] arr = {"Banana","Nana","Apple","Carrot","Beetroot","Mango","Orange","Apple","Carrot"};
		
		//sorting using the sort()
		sorting(arr);
		
		//sorting an array without using sort()
		sortingwithout(arr);
		
		//group the words using first letter
		groupbychar(arr);
		
		//searching in array
		search(arr,"Apple");
		
		//remove duplicate in array
		duplicate(arr);
		
		//duplicate without using set
		duplicatewithout(arr);
		
		//duplicate using map
		duplicateusingmap(arr);
		
		//stringjoiner
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("Java").add("Python").add("C++");
		System.out.println(joiner);
		
		//UUID
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		
		Random rand = new Random();
		int randomnum = rand.nextInt(100);
		System.out.println(randomnum);
		
		
		
		
	}
}

//functions- 
  //predicate<T> - test a condition (simply for checking a normal if condition like),
  //Function<T,R> - perform a function with variables and return result,
  //Consumer<T> - consume a object inside the lambda,
  //Supplier<T> - similar to consumer but it produce the obj but dont consume it

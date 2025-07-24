import java.util.*;
import java.util.stream.*;

public class Arraying {
  
  //second smallest element
  
  public static void secondsmall(int[] arr) {
    int result = Arrays.stream(arr)
                     .distinct()
                     .sorted()
                     .skip(1)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Array dont have second smallest element"));                   
  System.out.println(result);
  }
  
  //two arrays and find the common elements
  
  public static void common(int[] arr1,int[] arr2) {
    List<Integer> result = Arrays.stream(arr1)
                       .filter(arr1num -> Arrays.stream(arr2).anyMatch(arr2num -> arr2num == arr1num))
                       .boxed()
                       .distinct()
                       .collect(Collectors.toList());
    
    System.out.println(result);
  }
  
  //revers an array of integer in-place
  public static void reversing(int[] arr) {
    IntStream.range(0, arr.length/2)
            .forEach(i -> {
              int temp = arr[i];
              arr[i] = arr[arr.length - 1 -i];
              arr[arr.length -1 -i] = temp;
            });
    System.out.println(Arrays.toString(arr));
  }
  
  //sum of diagonal elements in an array
  public static void diagonalsum(int[][] arr) {
    int n = arr.length;
    int sum = 0;
    
    for(int i =0;i<n;i++) {
      sum+=arr[i][i];
    }
    System.out.println(sum);
  }
  
  //find the first longest element in the array
  public static void longeststring(String[] str) {
    String result = Arrays.stream(str)
                          .max(Comparator.comparingInt(String::length))
                          .orElse("No string found");
    System.out.println(result);
  }
  
  //find the names starting with A in the array
  public static void starta(String[] str) {
    List<String> result = Arrays.stream(str)
                                .filter(a->a.startsWith("A"))
                                .collect(Collectors.toList());
                                
    System.out.println(result);
  }
  
  //palindrome check
  public static void palicheck(String str) {
    boolean result = str.equals(new StringBuilder(str).reverse().toString());
    if(result) {System.out.println("Palindrome");}
    else {System.out.println("Not Palindrome");}
  }
  
  //count vowels and consonants
  public static void vowandcons(String str) {
    int vow = 0, con = 0;
    for(char c : str.toCharArray()) {
      if("aeiou".indexOf(c) != -1) {vow++;}
      else if(Character.isLetter(c)) {con++;}
    }System.out.println("Vowels :"+vow+"Consonants :"+con);
  }
  
  //duplicate character from string
  public static void removedup(String str) {
    StringBuilder result = new StringBuilder();
    for(char c : str.toCharArray()) {
      if(result.indexOf(String.valueOf(c))==-1) {result.append(c);}
    }System.out.println("After removing duplicates :"+result);
  }
  
  //find frequency of a character
  public static void frequency(String str) {
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : str.toLowerCase().toCharArray()) {
      freq.put(c, freq.getOrDefault(c,0)+1);
    }System.out.println(freq);
  }
  
  //remove duplicate in array
  public static void remodup(int[] arr) {
    List<Integer> result = Arrays.stream(arr)
                                 .distinct()
                                 .sorted()
                                 .boxed()
                                 .collect(Collectors.toList());
    System.out.println(result);
  }
  
  
  
  //main
  public static void main(String[] args) {
    
    int[] num = {1,2,8,1,4};
    secondsmall(num);
    
    int[] arr1 = {3,5,8,9,2};
    int[] arr2 = {3,9,2,5,3};
    common(arr1,arr2);
    
    reversing(num);
    
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
                      
    diagonalsum(matrix);
    
    String[] str = {"Apple","Banana","Orange","Grapes"};
    longeststring(str);
    
    List<String> list = Arrays.asList("a b","c d");
    list.stream().map(s -> s.split(" "));
    
    list.stream().flatMap(s -> Arrays.stream(s.split(" ")));
    
    String s1,s2,r,r1,r2;
    s1 = "Hello";
    s2 = "World";
    r=s1+" "+s2;    
    System.out.println(r);
    
    r1 = s1.concat(" ").concat(s2);
    System.out.println(r1);
    
    StringBuilder sb = new StringBuilder();
    sb.append(s1).append(" ").append(s2);
    r2 = sb.toString(); 
    System.out.println(r2);
    
    String str1 = "malayalam";
    palicheck(str1);
    
    String str2 = "An Apple is falling down";
    vowandcons(str2);
    
    String str3 = "There is more Duplicates in this sentence";
    removedup(str3);
    
    frequency(str3);
    
    remodup(arr2);
    
    String[] the = {"Apple","apricot","Banana"};
    String[] result;
    for(char c : the.toCharArray()) {
      if("Aa".indexOf(c) != -1) {result.append(c);}
      }System.out.println(result);
  }
}

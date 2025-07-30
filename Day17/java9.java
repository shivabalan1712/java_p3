import java.util.*;
import java.util.stream.*;

public class java9 {
  //using takehwile func
  public static List<Integer> takewhilefunc(int[] list) {
    return Arrays.stream(list)
                  .takeWhile(n->n<5)
                  .boxed()
                  .collect(Collectors.toList());
  }
  //using dropwhile func
  public static List<Integer> dropwhilefunc(int[] list) {
    return Arrays.stream(list)
                  .dropWhile(n->n<5)
                  .boxed()
                  .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    int[] list = {1,2,3,4,5,6,7,8,9};
    List<Integer> result = takewhilefunc(list);
    System.out.println(result);   
    
    List<Integer> result1 = dropwhilefunc(list);
    System.out.println(result1);
    
    
  }
}

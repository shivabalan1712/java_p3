import java.util.*;
import java.util.stream.*;

public class Streaming {
  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(9,6,8,3,1,10);
    
    //Stream<Integer> data = nums.stream();
    
    //data.forEach(n->System.out.println(n));
    
    //Stream<Integer> mapdata = data.map(n -> n*2);
    //mapdata.forEach(n->System.out.println(n));
    
    //nums.stream()
      //  .filter(n-> n%2 == 1)
      //  .sorted()
      //  .map(n->n*2)
      //  .forEach(n->System.out.println(n));
        
        
    int result = nums.stream()
                     .filter(n-> n%2 == 1)
                     .sorted()
                     .map(n->n*2)
                     .reduce(0,(c,e)->c+e);
                     
                     
    System.out.println(result);
  }
}

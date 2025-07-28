import java.util.*;

public class target {
  //find the target which sum up from two array
  public static int[] twoSumBurte(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }
  
  public static int[] twoSumEff(int[] arr,int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<arr.length;i++) {
      int find = target-arr[i];
      if(map.containsKey(find)) {
        return new int[] {map.get(find),i};
      }
      map.put(arr[i],i);
    }
    return new int[]{-1,-1};    
  }

  //find the maximum sub array with largest sum 
  public static int maxSubBrute(int[] arr) {
    int max = Integer.MIN_VALUE; //this is the largest negative value
    for(int i=0; i<arr.length;i++) {
      int sum =0;
      for (int j = i; j<arr.length;j++) {
        sum = sum + arr[j];
        max = Math.max(max,sum);
      }
    }return max;
  }
  
  public static int maxSubEff(int[] arr) {
    int maxsum = arr[0];
    int cursum = arr[0];
    for(int i=0;i<arr.length;i++) {
      cursum = Math.max(arr[i],cursum + arr[i]);
      maxsum = Math.max(maxsum,cursum);
    }
    return maxsum;
  }
  
  //Move zeroes
  public static void moveBrute(int[] arr) {
    int[] temp = new int[arr.length];
    int i =0;
    for (int ele : arr) {
      if(ele != 0) {
        temp[i++] = ele;
      }
    }System.arraycopy(temp, 0, arr,0,arr.length);
  }
  
  public static void moveEff(int[] arr) {
    int index=0;
    //move non 0 element to front
    for(int i=0;i<arr.length;i++) {
      if(arr[i] != 0) {
        arr[index] = arr[i];
        index++;
      }
    }
    //fill rest with 0
    while(index < arr.length) {
      arr[index] = 0;
      index++;
    }
  }
  
  //main
  
  public static void main(String[] args) {
  
    int[] arr1 = {1,2,3,4,5,6,7};
    int target = 11;
    System.out.println(Arrays.toString(twoSumBurte(arr1,target)));
    System.out.println(Arrays.toString(twoSumEff(arr1,target)));
    
    int[] arr2 = {-1,-2,4,7,-3,2,3};
    System.out.println(maxSubBrute(arr2));
    System.out.println(maxSubEff(arr2));
    
    int[] arr3 = {1,2,3,4,0,9,0,8,0,7,0};
    moveBrute(arr3);
    System.out.println(Arrays.toString(arr3));
    moveEff(arr3);
    System.out.println(Arrays.toString(arr3));
  }
}

import java.util.*;

class CommonEle {
	public static List<Integer> find(int[] a, int[] b) {
		List<Integer> res = new ArrayList<>();
		boolean[] visited = new boolean[b.length];
		
		for(int i=0;i<a.length;i++) {
		  for(int j=0;j<b.length;j++){
		    if(a[i]==b[j] && !visited[j]) {
		      res.add(a[i]);
		      visited[j] = true;
		      break;
		    }
		  }
		}
		return res;
	}
	public static void main(String[] args) {
	  int[] a={1,2,3,2,1,4};
	  int[] b={1,6,5,7,2,1};
	  
	  List<Integer> result = find(a,b);
	  System.out.print(result);
	}
}

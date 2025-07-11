public class Recursive {
	public static void main(String args[]) {
		int r = sum(10);
		System.out.println(r);
	}
	
	public static int sum(int k) {
		if(k>0) {
			return k + sum (k-1);
		}
		else {
			return 0;
		}
	}
}

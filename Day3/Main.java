 class Meth
{
  public int mul(int a, int b, int c, int d) {
		return a*b*c*d;
	}
	
	public int sub(int a, int b, int c, int d) {
	  return a-b-c-d;
	}
}
public class Main{
	public static void main(String args[]) {
	  Meth obj = new Meth();
		System.out.println(obj.mul(2,3,4,5));
	}
}

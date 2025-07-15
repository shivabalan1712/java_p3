public class Exhandle {
	void expt(int age) throws ArithmeticException{
		if (age >= 18) {
		  throw new ArithmeticException ("You are not eligible to Vote");
		}
	}
	public static void main(String[] args) {
	  Exhandle obj = new Exhandle();
	  int a = 17;
	  int b = 23;
	  obj.expt(a);
	  obj.expt(b);
		
	}
}

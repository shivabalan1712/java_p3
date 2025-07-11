class Calc {
	public String area(String a,int b) {
		return a + b*b;  //order
	}
	public String area(double r,String a) {
		return a + Math.PI*r*r; //order
	}
	public double area(double a, double b) {
		return 0.5*a*b; //type of
	}
	public int area(int a, int b) {
		return a*b; //number of , type of
	}
	public int area(int a, int b, int c) {
	  return a*b*c; //number of
	}
	}
public class Area {
  
	public static void main(String[] args) {
	  Calc obj = new Calc();
		System.out.println("Area of " + obj.area("Square",12));
		System.out.println("Area of " + obj.area(7.5,"Circle"));
		
		System.out.println("Area of Triangle :" + obj.area(11.5,14.7));
		
		System.out.println("Area of Rectangle :" + obj.area(11,17));
		System.out.println("Area of Cuboid :" + obj.area(11,13,15));
		
	}
}

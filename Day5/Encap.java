//private variable accessed by the methods of the class

class Person {
	private String name;
	
	public String getname() {
		return name;
	}
	
	public void setname(String namein) {
		this.name = namein;
	}
}

public class Encap {
	public static void main(String[] args) {
		Person obj = new Person();
		obj.setname("Shiva");
		System.out.println(obj.getname());
	}
}

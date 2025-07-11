public class Aclass {
	private int age;
	private String name;
	
	public Aclass(int age, String name){
		this.age = age;
		this.name =  name;
	}
	
	public void display() {
		System.out.println("Name : " + name + "Age : " + age);
	}
	
	public static void main(String[] args) {
		Aclass obj = new Aclass();
		obj.age = 22;
		obj.name = "Shiva";
		
		obj.display();
		
	}
}

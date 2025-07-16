class Home {
	public String bell;
	protected String ffkey;
	private String mainkey;
	
	public void ring() {
		System.out.println("Door bell rings :"+ bell);
	}
	
	protected void key() {
		System.out.println("Key of Tenant :"+ffkey);
	}
	
	private void mainkey() {
		System.out.println("Main key of the home :"+mainkey); 
	}
	
	public void Display() {
		mainkey = "ask Owner";
		mainkey();
	}
}

class Tenant extends Home {
	Tenant() {
		bell = "Ding Dong";
		ffkey = "FF101";
	}
}

public class Welcomehome {
	public static void main(String[] args) {
		Tenant t = new Tenant();
		//t.mainkey(); private method cant be accessed out side the class
		t.ring(); //public - accessed from anywhere
		t.key();  //protected - accessed by the class and sub classes inherited
		t.Display(); //private - only accessed inside the class and displayed here by method of the class
	}
}

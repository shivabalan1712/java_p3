interface parent1 {
	void fun();
}

interface parent2 {
	void fun();
}

class child implements parent1, parent2 {
	public void fun() {
		System.out.println("by the diamond problem");
	}
}

public class diamond {
	public static void main(String[] args) {
		child obj = new child();
		obj.fun();
	}
}

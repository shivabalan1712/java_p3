class Animal {
  public void sound(){
  System.out.println("Animal Makes Sound");
  }
}

class Dog extends Animal {
  public void sound() {
    System.out.println("Dog Barks");
  }
}

class Cat extends Animal {
  public void sound() {
    System.out.println("Cat Meows");
  }
}
class Poly {
  public static void main(String[] args) {
    Animal dog = new Dog();
	  Animal cat = new Cat();
	
	  dog.sound();
	  cat.sound();
    }
  }

	

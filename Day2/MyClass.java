public class MyClass {

    private int age;
    private String name;
    

    public MyClass(int age, String name) {
        this.age = age;
        this.name = name;
    }
    

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    

    public static void main(String[] args) {

        MyClass myObject = new MyClass(25, "John");
        

        myObject.displayInfo();
    }
}


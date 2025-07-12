class Employee {
    protected String empid;
    protected String name;
    double salary;

    public Employee(String empid, String name, double salary) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("\n Employee Details "+"\nEmployee ID : " + empid+"\nName : " + name+"\nSalary : Rs. " + salary);
    }
}

class Manager extends Employee {
    private double splallow;rrrrrrrrrrrrr

    public Manager(String empid, String name, double salary, double splallow) {
        super(empid, name, salary);
        this.splallow = splallow;
    }

    @Override
    public void display() {
        System.out.println("\nManager Details"+"\nManager ID : " + empid+"\nName : " + name+"\nBasic Salary : Rs. " + salary+"\nSpecial Allowance: Rs. " + splallow+"\nNet Salary : Rs. " + (salary + splallow));
        }
}

public class Employeemgt {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===");

        Employee e1 = new Employee("Eno9001", "Sendhil", 75000);
        e1.display();

        Manager e2 = new Manager("Mno8001", "Guna", 90000, 10000);
        e2.display();

        Employee e3 = new Employee("Mno8002", "Velu", 80000);
        e3.display();

        Employee e4 = new Manager("Mno8003", "Thambi", 75000, 8000);
        e4.display(); 
    }
}


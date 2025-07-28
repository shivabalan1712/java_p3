import java.util.*;

class Employee {
	
	private int id;
	private String name;
	private String dept;
	private List<Project> projects;
	private double salary;
	private String gender;
	
	public Employee(int id, String name, String dept, List<Project> projects, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.projects = projects;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() { return name; }
    public String getDept() { return dept; }
    public double getSalary() { return salary; }
    public List<Project> getProjects() { return projects; }
    public String getGender() { return gender; }

}


class Project{

	private String projectCode;
	private String name ;
	private String client;
	private String buLeadName;
	
	public Project(String projectCode, String name, String client, String buLeadName) {
        this.projectCode = projectCode;
        this.name = name;
        this.client = client;
        this.buLeadName = buLeadName;
    }
    
    public String getName() { return name; }
    public String getClient() { return client; }
    public String getBuLeadName() { return buLeadName; }
      
}

public class EmployeeDataBase {

    public static List<Employee> getAllEmployees() {
        Project p1 = new Project("P001", "NammaApp", "AutoMate Chennai", "Ajith");
        Project p2 = new Project("P002", "ChittiGPT", "MindTree Tamilnadu", "Beema");
        Project p3 = new Project("P003", "KudilKart", "ZingBuy India", "Ajith");
        Project p4 = new Project("P004", "SoruTracker", "AnnaMess Pvt Ltd", "Charan");
        Project p5 = new Project("P005", "FinSoru", "PaisaPaatu", "Dinesh");
        Project p6 = new Project("P006", "ClassNinja", "VidyaVerse", "Elakkiya");
        Project p7 = new Project("P007", "BrandBoost TN", "Kovai Creatives", "Farook");
        Project p8 = new Project("P008", "Trendify", "InstaSoft Chennai", "Gaya3");
        Project p9 = new Project("P009", "FlashMove", "ZippyRides", "Hari");
        Project p10 = new Project("P010", "MoodMate", "DigitalSangam", "Ishwarya");


        // Employee instances
        Employee e1 = new Employee(1, "Kavin Raj", "Development", Arrays.asList(p1, p2), 80000, "Male");
        Employee e2 = new Employee(2, "Shruti S", "Development", Arrays.asList(p3), 80000, "Female");
        Employee e3 = new Employee(3, "Yuvan V", "Sales", Arrays.asList(p4), 60000, "Male");
        Employee e4 = new Employee(4, "Sneha P", "HR", Arrays.asList(p1), 55000, "Female");
        Employee e5 = new Employee(5, "Harish M", "Finance", Arrays.asList(p5), 90000, "Male");
        Employee e6 = new Employee(6, "Divya Sri", "Development", Arrays.asList(p6), 85000, "Female");
        Employee e7 = new Employee(7, "Kishore T", "Marketing", Arrays.asList(p7), 72000, "Male");
        Employee e8 = new Employee(8, "Ananya V", "Development", Arrays.asList(p8), 88000, "Female");
        Employee e9 = new Employee(9, "Vikram L", "Sales", Arrays.asList(p9), 78000, "Male");
        Employee e10 = new Employee(10, "Jeni K", "Development", Arrays.asList(p10), 95000, "Female");    

        
        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
  
    }
}

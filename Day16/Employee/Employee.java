package Employee;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Employee{
	
	private int id;
	private String name;
	private String dept;
	private List<Project> projects;
	private double salary;
	private String gender;

}
	
	// public Employee(int id, String name, String dept, List<Project> projects, double salary, String gender) {
    //     this.id = id;
    //     this.name = name;
    //     this.dept = dept;
    //     this.projects = projects;
    //     this.salary = salary;
    //     this.gender = gender;
    // }

    // public int getId() {return id;}
    // public String getName() { return name; }
    // public String getDept() { return dept; }
    // public double getSalary() { return salary; }
    // public List<Project> getProjects() { return projects; }
    // public String getGender() { return gender; }

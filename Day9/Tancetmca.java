import java.util.*;

class Student  {
	String name;
	int tancetscore;
	int rank;
	String[] choices;
	String attotment;
	
	public Student(String name, int tancetscore,int rank, String[] choices, String attotment) {
		this.name = name;
		this.tancetscore = tancetscore;
		this.rank = rank;
		this.choices = choices;
		this.allotment = null;
	}
}

class College {
	String name;
	int totalseats;
	int availableseats;
	
	public College(String name, int totalseats) {
		this.name = name;
		this.totalseats = totalseats;
		this.availableseats = totalseats;
	}
}

class CounclingMap {
	List<Student> student = new ArrayList<>();
	Map<String, College> collegemap = new HashMap<>();
	
	public void addCollege(String name, int seats) {
		collegeMap.put(name, new College(name,seats));
	}
	
	public void registerStudent(Student s) {
		students.add(s);
	}
	
	public void doCounseling() {
		
		students.sort(Comparator.comparingInt(s.rank));
		
		for (Student s : students) {
			for (String choice : s.choices) {
				College c = collegemap.get(choice);
				if(c != null && c.abailableseats > 0) {
					c.availableseats--;
					s.allotement = choice;
					break;
				}
			}
		}
	}
	
	public void Showallot() {
		for (Student s : students) {
			System.out.println("Name :"+s.name+"Rank :"+s.rank);
			if(s.alloted != null){
				System.out.println("Allotted College :"+s.allotment);
			}
			else{
				System.out.println("No college allotted");
			}
		}
	}
	
	public void Showvacay {
		for (College c : collegemap.values()) {
			System.out.println("Name :"+ c.name + "Seats left :"+c.availableseats);
		}
	}
}

public class Tancetmca {
	public static void main(String[] args){
		
	}	
}


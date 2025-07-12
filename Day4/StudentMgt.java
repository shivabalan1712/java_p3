import java.util.*;

class Student {
  String name,year,dept;
    
  public void addStudent(Scanner sc) {
    System.out.print("Enter name : ");
    sc.nextLine();
    name = sc.nextLine();
    System.out.print("Enter Year : ");
    year = sc.nextLine();
    System.out.print("Enter Department : ");
    dept = sc.nextLine();
  }
}

class Marksheet extends Student {
  int java,c,dsa,cn,cpp,total;
  String result;
  
  public void EnterMarks(Scanner sc) {
    System.out.print("Enter Marks in Java : ");
    java = sc.nextInt();
    System.out.print("Enter Marks in C : ");
    c = sc.nextInt();
    System.out.print("Enter Marks in DSA : ");
    dsa = sc.nextInt();
    System.out.print("Enter Marks in CN : ");
    cn = sc.nextInt();
    System.out.print("Enter Marks in C++ : ");
    cpp = sc.nextInt();
    Result();
  }
  
  public void Result() {
    total = java+c+dsa+cn+cpp;
    if (java > 35 && c > 35 && dsa > 35 && cn > 35 && cpp > 35) {
      result = "Pass";
    }
    else {
      result = "Fail";
    }
  }
  
  public void Display(int rank) {
    System.out.println("\n==== Mark Statement ====\nRank       : "+rank+" \nName       : "+name+"\nYear       : "+year+"\nDepartment : "+dept+"\nJava       : "+java+"\nC          : "+c+"\nDSA        : "+dsa+"\nCN         : "+cn+"\nC++        : "+cpp+ "\nTotal      :"+total+"\nResult     : "+result);
  }
}

public class StudentMgt {
	static ArrayList <Marksheet> students = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
  public static void main(String args[]) {
    int choice;
    
    do{
      System.out.println("\n==== Student Management System ====\n1. Add Student\n2. View All Students\n3. Display Results\n4. Exit\nEnter Your Choice : ");
      choice = sc.nextInt();
      
      switch(choice) {
        case 1:
          Marksheet m = new Marksheet();
          m.addStudent(sc);
          m.EnterMarks(sc);
          students.add(m);
          System.out.println("Student added successfully!");
          break;
        case 2:
          if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
          }
          
          students.sort((a, b) -> b.total - a.total);

          int rank = 1;
          for (Marksheet ma : students) {
             ma.Display(rank++);
          }
          break;
        case 3:
          Stats();
          break;
        case 4:
          System.out.println("***Thanking You***");
          break;
        default:
          System.out.println("Enter only Valid Option...");
      }
    }while(choice != 4);
  }
  public static void Stats() {
    if (students.isEmpty()) {
        System.out.println("No Students");
        return;
    }

    int n = students.size();
    int totJava = 0, totC = 0, totDsa = 0, totCn = 0, totCpp = 0;

    for (Marksheet m : students) {
        totJava += m.java;
        totC += m.c;
        totDsa += m.dsa;
        totCn += m.cn;
        totCpp += m.cpp;
    }
    
    System.out.println("\n===== Subject Average Marks =====\nJava : "+(totJava/n)+"\nC    : "+(totC/n)+"\nDSA  : "+(totDsa/n)+"\nCN   : "+(totCn/n)+"\nC++  : "+(totCpp/n));
}

}

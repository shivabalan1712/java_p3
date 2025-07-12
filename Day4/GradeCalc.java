import java.util.*;

class Student {
  String name;
  String year;
  String dept;
  
  public void addStudent(Scanner sc) {
    System.out.print("Enter name : ");
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
  
  public void Display() {
    System.out.println("\n==== Mark Statement ==== \nName       : "+name+"\nYear       : "+year+"\nDepartment : "+dept+"\nJava       : "+java+"\nC          : "+c+"\nDSA        : "+dsa+"\nCN         : "+cn+"\nC++        : "+cpp+ "\nTotal      :"+total+"\nResult     : "+result);
  }
}

public class GradeCalc {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Marksheet m = new Marksheet();
    
    m.addStudent(sc);
    m.EnterMarks(sc);
    m.Result();
    m.Display();
    
    sc.close();
  }
}

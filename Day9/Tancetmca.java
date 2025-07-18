import java.util.*;

class Student {
    String name;
    double tancetScore;
    int rank;
    String[] choices;
    String allotment;

    public Student(String name, double tancetScore, int rank, String[] choices) {
        this.name = name;
        this.tancetScore = tancetScore;
        this.rank = rank;
        this.choices = choices;
        this.allotment = null;
    }
}

class College {
    String name;
    int totalSeats;
    int availableSeats;

    public College(String name, int totalSeats) {
        this.name = name;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
}

class Counseling {
    List<Student> students = new ArrayList<>();
    Map<String, College> collegeMap = new HashMap<>();

    public void addCollege(String name, int seats) {
        collegeMap.put(name.trim().toLowerCase(), new College(name.trim(), seats));
    }
    
    public boolean isValidCollege(String name) {
      return collegeMap.containsKey(name.trim().toLowerCase());
    }


    public void registerStudent(Student s) {
        students.add(s);
    }

    public void doCounseling() {
        students.sort(Comparator.comparingInt(s -> s.rank));

        for (Student s : students) {
            for (String choice : s.choices) {
                College c = collegeMap.get(choice.trim());
                if (c != null && c.availableSeats > 0) {
                    c.availableSeats--;
                    s.allotment = c.name;
                    break;
                }
            }
        }
    }

    public void showAllotments() {
        System.out.println("\n=======================================================");
        System.out.println("            TAMILNADU MBA/MCA ADMISSIONS 2025            ");
        System.out.println("     DIRECTORATE OF TECHNICAL EDUCATION, CHENNAI - 25\n  ");
        System.out.println("  GOVERNMENT COLLEGE OF TECHNOLOGY, COIMBATORE - 641 013 ");
        System.out.println("      MASTER OF COMPUTER APPLICATION (MCA) - 2025 ");
        System.out.println("\n                    STUDENT ALLOTMENT\n");
        System.out.println("=======================================================\n");
        for (Student s : students) {
            System.out.println("Name: " + s.name + " | Rank: " + s.rank);
            if (s.allotment != null) {
                System.out.println("Allotted College: " + s.allotment);
            } else {
                System.out.println("No college allotted.");
            }
            System.out.println("------------------------------------");
        }
        System.out.println("=======================================================\n");
    }

    public void showVacancy() {
        System.out.println("------------------------------------");
        for (College c : collegeMap.values()) {
            System.out.println(c.name + " - "+c.availableSeats+" seats available");
        }
        System.out.println("------------------------------------");
    }
}

public class Tancetmca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Counseling co = new Counseling();

        co.addCollege("CEG", 2);
        co.addCollege("GCT", 1);
        co.addCollege("PSG", 1);
        co.addCollege("TCE", 1);
        System.out.println("\n=======================================================");
        System.out.println("            TAMILNADU MBA/MCA ADMISSIONS 2025            ");
        System.out.println("     DIRECTORATE OF TECHNICAL EDUCATION, CHENNAI - 25\n  ");
        System.out.println("  GOVERNMENT COLLEGE OF TECHNOLOGY, COIMBATORE - 641 013 ");
        System.out.println("  MASTER OF COMPUTER APPLICATION (MCA) - 2025 APPLICATION");
        System.out.println("=======================================================\n");

        while (true) {
            
            System.out.println("\n1. Student Registration\n2. Perform Counseling\n3. Show Allotments\n4. Show College Vacancy\n5. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("\n Enter Student Name: ");
                    String name = sc.nextLine();
                    double score;
                    while (true) {
                      System.out.print("Enter TANCET Score (0 - 100): ");
                      score = sc.nextDouble();
                      if (score >= 0 && score <= 100) {break;}
                      else 
                      {System.out.println("Invalid score. Please enter a value between 0 and 100.");}
                    }
                    System.out.print("Enter your Rank: ");
                    int rank = sc.nextInt();
                    sc.nextLine(); 
                    String[] choices;
                    while (true) {
                      System.out.println("\n List of available Colleges and seats:");
                      co.showVacancy();
                      System.out.print("Enter College Choices separated by comma (,): ");
                      String input = sc.nextLine();
                      choices = input.split(",");

                      boolean allValid = true;
                      List<String> invalidNames = new ArrayList<>();

                      for (String c : choices) {
                        if (!co.isValidCollege(c)) {
                            allValid = false;
                            invalidNames.add(c.trim());
                        }
                      }
                      if (allValid) break;
                      System.out.println("\n Invalid College Name(s): " + invalidNames);
                      System.out.println("Please re-enter valid college names.");
                    }
                    co.registerStudent(new Student(name, score, rank, choices));
                    break;

                case 2:
                    co.doCounseling();
                    System.out.println("Counseling Completed.");
                    break;

                case 3:
                    co.showAllotments();
                    break;

                case 4:
                    co.showVacancy();
                    break;

                case 5:
                    System.out.println("**** Thanking You! Happy Collegian ****");
                    return;

                default:
                    System.out.println("Enter valid option only.");
            }
        }
    }
}


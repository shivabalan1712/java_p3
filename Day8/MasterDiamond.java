import java.util.*;

interface Univ {
    default void Show() {
        System.out.println("Main University");
    }
}

interface BranchM extends Univ {
    @Override
    default void Show() {
        System.out.println("Main Branch");
    }
}

interface CourseM extends Univ {
    @Override
    default void Show() {
        System.out.println("Main Course");
    }
}

class University {
    private String name;
    private List<Branch> branches = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addBranch(Branch b) {
        branches.add(b);
    }

    public void Show() {
        System.out.println("University: " + name);
        for (Branch b : branches) {
            b.Show();
        }
    }
}

class Branch {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void Show() {
        System.out.println("Branch: " + name);
        for (Course c : courses) {
            c.Show();
        }
    }
}

class Course {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void Show() {
        System.out.println("Course: " + name);
        for (Student s : students) {
            s.Show();
        }
    }
}

class Student implements BranchM, CourseM {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void Show() {
        System.out.println("Student Name: " + name);
    }
}

public class MasterDiamond {
    public static void main(String[] args) {
        University uni = new University("Anna University");

        Branch dist = new Branch("Dept of Info Sci and Tech");
        Course mca = new Course("MCA");
        Course be = new Course("BE");

        Student shiva = new Student("Shiva");
        Student balan = new Student("Balan");

        mca.addStudent(shiva);
        be.addStudent(balan);

        dist.addCourse(mca);
        dist.addCourse(be);

        uni.addBranch(dist);

        uni.Show();
    }
}


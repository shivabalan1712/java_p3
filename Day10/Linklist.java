import java.util.*;

public class Linklist {
    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<>();

        books.add("Java");
        books.add("Python");
        books.add("C++");
        books.addFirst("HTML");
        books.addLast("JavaScript");

        System.out.println("Books: " + books);

        books.remove("C++");
        books.removeFirst();
        books.removeLast();

        System.out.println("Updated Books: " + books);
        System.out.println("First Book: " + books.getFirst());
        System.out.println("Last Book: " + books.getLast());

        for (String book : books) {
            System.out.println("Book: " + book);
        }
    }
}


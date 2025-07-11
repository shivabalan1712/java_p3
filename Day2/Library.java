//library management 

//lib-> isbn, book name, author
//trasction -> borrow, return 
//borrow check for availability
//submit add to the linkedlist


import java.util.*;

public class Library {
    static class Book {
        public String isbn;
        public String booktitle;
        public String author;
        public boolean isBorrowed;

        public Book(String isbn, String booktitle, String author) {
            this.isbn = isbn;
            this.booktitle = booktitle;
            this.author = author;
            this.isBorrowed = false;
        }

        public String getDetails() {
            return "Book Title: " + booktitle + " | Author: " + author + " | ISBN: " + isbn + " | Status: " + (isBorrowed ? "Borrowed" : "Available");
        }
    }

    static ArrayList<Book> books = new ArrayList<>();


    public static void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
        System.out.println("Book added successfully.");
    }


    public static void findBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println(book.getDetails());
                return;
            }
        }
        System.out.println("Book not found.");
    }


    public static void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                if (!book.isBorrowed) {
                    book.isBorrowed = true;
                    System.out.println("Book borrowed: " + book.booktitle);
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }


    public static void returnBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                if (book.isBorrowed) {
                    book.isBorrowed = false;
                    System.out.println("Book returned: " + book.booktitle);
                } else {
                    System.out.println("Book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System ===== \n 1.Add Book \n2.Find Book \n3.Borrow Book \n4.Return Book \n5.Display All Books\n6.Exit\nEnter Your Choice : ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN number: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String booktitle = sc.nextLine();
                    System.out.print("Enter Book Author Name: ");
                    String author = sc.nextLine();
                    addBook(isbn, booktitle, author);
                    break;

                case 2:
                    System.out.print("Enter ISBN to find book: ");
                    String findisbn = sc.nextLine();
                    findBook(findisbn);
                    break;

                case 3:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowisbn = sc.nextLine();
                    borrowBook(borrowisbn);
                    break;

                case 4:
                    System.out.print("Enter ISBN to return: ");
                    String returnisbn = sc.nextLine();
                    returnBook(returnisbn);
                    break;

                case 5:
                    System.out.println("\nList of all books:");
                    for (Book b : books) {
                        System.out.println(b.getDetails());
                    }
                    break;

                case 6:
                    System.out.println("***Thanking You***");
                    break;

                default:
                    System.out.println("Enter Only Valid Options...");
            }
        } while (choice != 6);

        sc.close();
    }
}


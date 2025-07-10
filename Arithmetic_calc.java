import java.util.Scanner;

public class Arithmetic_calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        
        System.out.println("Choose Operation");
        System.out.println("Enter 1 for Addition (+)");
        System.out.println("Enter 2 for Subtraction (-)");
        System.out.println("Enter 3 for Multiplication (*)");
        System.out.println("Enter 4 for Division (/)");
        System.out.print("Enter your choice: ");
        
        int c = sc.nextInt();

        if (c >= 1 && c <= 4) {
            int result = switch (c) {
                case 1 -> a + b;
                case 2 -> a - b;
                case 3 -> a * b;
                case 4 -> {
                    if (b != 0) yield a / b;
                    else {
                        System.out.println("Error: Division by zero.");
                        yield 0;
                    }
                }
                default -> 0; 
            };
            System.out.println("Result: " + result);
        } else {
            System.out.println("Enter only between 1 - 4");
        }

        sc.close();
    }
}

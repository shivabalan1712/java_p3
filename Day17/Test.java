import java.util.*;
import java.util.stream.*;

public class Test {

    public static void main(String[] args) {
        int[] sizes = {100000, 1000000, 5000000, 10000000};

        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);

            //Sequential - Boxed
            List<Integer> boxedList = IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
            measure("Sequential Stream (Boxed)", () -> {
                long sum = boxedList.stream()
                        .mapToLong(x -> (long) x * x)
                        .sum();
                // System.out.println("Sum: " + sum);
            });

            //Parallel - Boxed
            measure("Parallel Stream (Boxed)", () -> {
                long sum = boxedList.parallelStream()
                        .mapToLong(x -> (long) x * x)
                        .sum();
                // System.out.println("Sum: " + sum);
            });

            //Sequential - Primitive
            measure("Sequential Stream (Primitive)", () -> {
                long sum = IntStream.rangeClosed(1, size)
                        .mapToLong(x -> (long) x * x)
                        .sum();
                // System.out.println("Sum: " + sum);
            });

            //Parallel - Primitive
            measure("Parallel Stream (Primitive)", () -> {
                long sum = IntStream.rangeClosed(1, size)
                        .parallel()
                        .mapToLong(x -> (long) x * x)
                        .sum();
                // System.out.println("Sum: " + sum);
            });
        }
    }

    public static void measure(String label, Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        System.out.println(label + " - Time: " + (end - start) + " ms");
    }
}


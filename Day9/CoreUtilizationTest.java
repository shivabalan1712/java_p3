import java.util.concurrent.*;

public class CoreUtilizationTest {

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Logical Processors: " + coreCount);

        ExecutorService executor = Executors.newFixedThreadPool(coreCount);


        for (int i = 1; i <= coreCount; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " started on Thread: " + Thread.currentThread().getName());
                long sum = 0;
                for (long j = 1; j < 100000000L; j++) {
                    sum += j % 123;
                }
                System.out.println("Task " + taskId + " completed on Thread: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}


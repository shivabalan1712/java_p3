import java.util.concurrent.*;

public class completablefuturework {
    public static void func(int number){
      CompletableFuture.supplyAsync(() -> number * number) 
            .thenApply(square -> square + 10)                
            .thenAccept(result -> System.out.println("Final: " + result)) 
            .thenRun(() -> System.out.println("All done!")) 
            .exceptionally(ex -> {
                System.out.println("Something went wrong: " + ex.getMessage());
                return null;
            });

       try { Thread.sleep(1000); } catch (Exception e) {}
    }

    public static void main(String[] args) {
        int number = 5;
        func(number);
        
        int n = -1;
        func(n);

        
    }
}


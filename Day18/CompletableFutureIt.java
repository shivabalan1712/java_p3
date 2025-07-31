import java.util.concurrent.*;

public class CompletableFutureIt {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> "User123");

        CompletableFuture<String> greeting = user
            .thenApply(id -> "Hello, " + id)
            .thenApply(str -> str.toUpperCase())
            .thenCombine(CompletableFuture.supplyAsync(() -> "Task Done"), 
                         (msg, status) -> msg + " - " + status)
            .exceptionally(ex -> "Something failed: " + ex.getMessage());

        System.out.println(greeting.get());
    }
}

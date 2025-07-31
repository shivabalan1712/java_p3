import java.util.concurrent.*;

public class CompletableFuturing{
    public static CompletableFuture<String> getUser() {
        return CompletableFuture.supplyAsync(()->"Shiva");
    }

    public static CompletableFuture<String> getGreet(String name) {
        return CompletableFuture.supplyAsync(()->"Hello "+name);
    }

    // public 
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> result = getUser()
                                            .thenCompose(name->getGreet(name))
                                            .thenApply(msg->msg+" from Apply")
                                            .exceptionally(ex->"Error : "+ex.getMessage()); 
    
    
        System.out.println(result.get());
    
    
    }
}
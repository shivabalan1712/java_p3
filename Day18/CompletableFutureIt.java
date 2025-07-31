import java.util.concurrent.*;

import javax.management.RuntimeErrorException;

public class CompletableFutureIt {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "This is from Async";
        });
        System.out.println(future.get());
    
        CompletableFuture<String> greet = CompletableFuture
                                            .supplyAsync(()->"Hello")
                                            .thenApply(str->str +" World");

        System.out.println(greet.get());

        CompletableFuture<Void> accept = CompletableFuture
                                            .supplyAsync(()->42)
                                            .thenAccept(num -> System.out.println("Received :"+num));
    
        System.out.println(accept.join());
        
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->"Shiva ");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()-> "Balan") ;
    
        CompletableFuture<String> combined = cf1.thenCombine(cf2,(a,b)->a+b);
        System.out.println(combined.get());

        CompletableFuture<String> risk = CompletableFuture
                                            .supplyAsync(()->
                                                {
                                                    if(true) throw new RuntimeException("This is wrong");
                                                    return "Fine";
                                                }
                                            )
                                            .exceptionally(ex->"Error : "+ex.getMessage());

        System.out.println(risk.get());
    }

}

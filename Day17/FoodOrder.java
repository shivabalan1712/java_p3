import java.util.concurrent.*;

public class FoodOrder {
  public static void main(String[] args) {
    CompletableFuture.supplyAsync(()-> {System.out.println("Ordering food");
                                        return "Chicken ";})
                      .thenApply(food->food+"With alfaham infused..")
                      .thenAccept(finalfood->System.out.println("Eating: "+finalfood))
                      .thenRun(()->System.out.println("Tasty chicken"))
                      .exceptionally(ex->{System.out.println("Order failed: "+ex.getMessage());
                                          return null;});
                      
    try{Thread.sleep(1000);}catch(Exception e) {}
  }
}


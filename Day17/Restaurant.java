import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Restaurant {
    static final int inventory = 10;
    static final Set<String> meal = Set.of("Pizza", "Burger", "Pasta", "Fries", "Sandwich");
    static final Set<String> drink = Set.of("Juice", "Soda", "Water", "Milkshake");

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            var foodOrder = getItems(sc, "Food", meal);
            var drinkOrder = getItems(sc, "Drink", drink);

            var foodFuture = processOrder("Food", foodOrder, meal);
            var drinkFuture = processOrder("Drink", drinkOrder, drink);

            foodFuture.thenCombine(drinkFuture, (f, d) -> f + "\n" + d)
                      .thenAccept(System.out::println)
                      .exceptionally(e -> {
                          System.out.println(" Order Failed: " + e.getMessage());
                          return null;
                      }).join();
        }
    }

    static CompletableFuture<String> processOrder(String type, Map<String, Integer> order, Set<String> menu) {
        return CompletableFuture.supplyAsync(() -> {
            int total = order.values().stream().mapToInt(Integer::intValue).sum();
            if (total > inventory) throw new IllegalArgumentException(type + " limit exceeded (max " + inventory + ")");
            for (String item : order.keySet())
                if (!menu.contains(item)) throw new IllegalArgumentException(type + " item unavailable: " + item);
            simulateDelay();
            return type + " ordered: " + format(order);
        });
    }

    static Map<String, Integer> getItems(Scanner sc, String type, Set<String> menu) {
        System.out.println("Enter " + type + " items (e.g., Pizza:2,Burger:1):");
        return Arrays.stream(sc.nextLine().split(","))
                .map(s -> s.split(":"))
                .filter(p -> p.length == 2)
                .collect(Collectors.toMap(
                        p -> p[0].trim(),
                        p -> Integer.parseInt(p[1].trim()),
                        Integer::sum,
                        LinkedHashMap::new
                ));
    }

    static String format(Map<String, Integer> map) {
        return map.entrySet().stream()
                  .map(e -> e.getKey() + " x" + e.getValue())
                  .collect(Collectors.joining(", "));
    }

    static void simulateDelay() {
        try { Thread.sleep(400); } catch (InterruptedException ignored) {}
    }
}

import java.util.*;

public class Vectors {
    public static void main(String[] args) {

        Vector<String> animals = new Vector<>();

        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Elephant");
        animals.add("Lion"); 
        System.out.println("Initial Vector: " + animals);

        //add(int index, E element)
        animals.add(1, "Leopard");
        System.out.println("After adding at index 1: " + animals);

        //get(int index)
        System.out.println("Element at index 2: " + animals.get(2));

        //set(int index, E element)
        animals.set(2, "Panther");
        System.out.println("After setting index 2 to 'Panther': " + animals);

        //remove(Object o)
        animals.remove("Lion"); // removes first occurrence
        System.out.println("After removing 'Lion': " + animals);

        //remove(int index)
        animals.remove(2); // removes element at index 2
        System.out.println("After removing element at index 2: " + animals);

        //contains(Object o)
        System.out.println("Contains 'Tiger'? " + animals.contains("Tiger"));

        //indexOf(Object o)
        System.out.println("Index of 'Tiger': " + animals.indexOf("Tiger"));

        //lastIndexOf(Object o)
        animals.add("Tiger"); // Add duplicate
        System.out.println("Last index of 'Tiger': " + animals.lastIndexOf("Tiger"));

        //isEmpty()
        System.out.println("Is vector empty? " + animals.isEmpty());

        //size()
        System.out.println("Size of vector: " + animals.size());

        //capacity()
        System.out.println("Current capacity: " + animals.capacity());

        //firstElement(), lastElement()
        System.out.println("First element: " + animals.firstElement());
        System.out.println("Last element: " + animals.lastElement());

        //toArray()
        Object[] arr = animals.toArray();
        System.out.println("Vector as Array: " + Arrays.toString(arr));

        //forEach() 
        System.out.println("Using forEach():");
        animals.forEach(a -> System.out.println("- " + a));

        //trimToSize()
        animals.trimToSize();
        System.out.println("Capacity after trimToSize(): " + animals.capacity());

        //clear()
        animals.clear();
        System.out.println("Vector after clear(): " + animals);
        System.out.println("Is vector empty now? " + animals.isEmpty());
    }
}


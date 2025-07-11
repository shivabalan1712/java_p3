import java.util.*;

public class LinkedListImp {
	public static void main(String[] args){
		LinkedList <String> list = new LinkedList<>();
		
		list.add("one");
		list.add("element");
		list.addFirst("first");
		list.addLast("Last");
		
		list.removeFirst();
		
		
		
		for (String i : list) {
			System.out.println(i);
		}
	}
}






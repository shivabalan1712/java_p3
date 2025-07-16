import java.io.*;
import java.util.*;

public class Filehand {
	public static void main(String[] args) {
		File newfile = new File("Apple.txt");
		
		try {
		  
			if(newfile.createNewFile()) {
				System.out.println("File Created :"+newfile.getName());
			}
			else {
				System.out.println("File already Exists");
			}
			
			FileWriter writer = new FileWriter("Apple.txt");
			writer.write("This is from the code to file");
			writer.close();
			System.out.println("Written in file");
			
			Scanner sc = new Scanner(new File("Apple.txt"));
			while(sc.hasNextLine()){
			  String data = sc.nextLine();
			  System.out.println("Content :"+data);
			}sc.close();			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		  if(newfile.delete()) {
		    System.out.println("Deleted file :"+newfile.getName());
		  } 
		  else {
		    System.out.println("Failed to delete");
		  }
		}
	}
}

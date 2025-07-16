import java.util.*;
import java.io.*;

public class Advfilehand {
	public static void main(String[] args) {
		try{
			BufferedWriter wt = new BufferedWriter(new FileWriter("Banana.txt"));
			wt.write("This is Shiva \nCompeleted MCA from CEG,Anna University\nJava Developer");
			wt.close();
			BufferedReader rd = new BufferedReader(new FileReader("Banana.txt"));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println("Reading :"+line);
			}
			rd.close();
		} catch(IOException e) {
		  e.printStackTrace();
		} 
	}
}

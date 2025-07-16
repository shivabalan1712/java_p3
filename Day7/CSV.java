import java.io.*;

public class CSV {
	public static void main(String[] args) {
		String[] cols = {"Name","Age"};
		String[] row1 = {"Shiva","23"};
		String[] row2 = {"Balan","25"};
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("Student.csv"))) {
			bw.write(String.join(",",cols));
			bw.newLine();
			bw.write(String.join(",",row1));
			bw.newLine();
			bw.write(String.join(",",row2));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("Student.csv"))) {
			String line;
			System.out.println("\n Reading file ");
			while ((line = br.readLine()) !=null) {
				String[] values = line.split(",");
				System.out.println("Name :"+values[0]+", Age :"+values[1]);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

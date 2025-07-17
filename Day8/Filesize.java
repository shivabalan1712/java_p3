import java.io.File;

public class Filesize {

    public static void main(String[] args) {

        String folderPath = "/home/bat"; 
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder not found or is not a directory.");
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }

        System.out.println("Files larger than 20 KB in '" + folderPath + "':\n");

        boolean found = false;
        for (File file : files) {
            if (file.isFile() && file.length() > 2 * 1024) {
                System.out.println(file.getName() + " -> " + file.length() / 1024 + " KB");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No files exceed 2 KB.");
        }
    }
}


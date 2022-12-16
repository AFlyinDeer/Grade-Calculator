import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader {
  public static String ReadFileFromPath (String path) {
    String allLines = "";
    try {
      File file = new File(path);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        allLines = allLines + data + ",";
      }
      scanner.close();
      return allLines;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return allLines;
  }
}

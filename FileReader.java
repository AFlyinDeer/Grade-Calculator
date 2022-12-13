import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader {
  public static String[] readFileFromPath (String path) {
    try {
      File file = new File("C:\\Users\\Darth Wader\\Desktop\\School\\Semester 4\\Java\\Projects\\Final\\grades_1H1.txt");
      Scanner scanner = new Scanner(file);
      String allLines = "";
      while (scanner.hasNextLine()) {
        String data = scanner.nextLine();
        allLines = allLines + data + ",";
        
      }
      allLines = allLines.substring(0, allLines.length() - 1);
      String[] stringNumbers = allLines.split(",");
      
      scanner.close();
      return stringNumbers;

    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    String[] results = {"a","b","c"};
    return results;
  }
}
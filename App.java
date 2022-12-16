public class App {
    public static void main(String[] args) {
        System.out.print("Enter the fully qualified path of the file you would like to access:\n");
        String path = System.console().readLine();
        String formattedPath = path.replace("\\", "\\\\");

        String allLines = FileReader.ReadFileFromPath(formattedPath);
        String[] gradesCSV = ConvertStringToStringArray(allLines);
        int[] grades = ConvertStringArrayToIntArray(gradesCSV);

        GradeData gradeData = new GradeData(grades);
        gradeData.toString();
    }

    private static String[] ConvertStringToStringArray(String allLines){
        allLines = allLines.substring(0, allLines.length() - 1);
        String[] stringNumbers = allLines.split(",");
        return stringNumbers;
    }

    private static int[] ConvertStringArrayToIntArray(String[] strArray){
        int[] intArray = new int[strArray.length];
        for(int i = 0;i < strArray.length;i++)        
        {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }
}

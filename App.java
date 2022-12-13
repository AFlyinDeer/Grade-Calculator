public class App {

    public static void main(String[] args) {
        
        System.out.print("Enter the fully qualified path of the file you would like to access:\n");
        String path = System.console().readLine();

        String[] splitRawData = FileReader.readFileFromPath(path);
        int[] grades = ConvertStringArrayToIntArray(splitRawData);

        
        System.out.println(grades.length);
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





// convert splitrawdata into int array
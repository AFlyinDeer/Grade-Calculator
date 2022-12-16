import static java.lang.Math;
import java.text.DecimalFormat;

public class GradeData {
    public double Mean;
    public double SD;
    public int[] Grades;

    public GradeData(int[] grades){
        Grades = grades;
        Mean = CalculateMean();
        SD = CalculateSD();
    }

    private double CalculateMean(){
        double total = 0;
        for (int i = 0; i < Grades.length; i++) {
            total += Grades[i];
        }
        double mean = total / Grades.length;
        return mean;
    }

    private double CalculateSD(){
        double sumOfNumbers = 0;
        for (int i = 0; i < Grades.length; i++) {
            sumOfNumbers += Math.pow((Grades[i] - Mean), 2);
        }
        double sd = Math.sqrt(sumOfNumbers / (Grades.length - 1));
        return sd;
    }
    
    @Override
    public String toString(){
        System.out.println("Number of grades: " + Grades.length);
        System.out.println("Mean: " + RoundToPlace(Mean, "0.00"));
        System.out.println("Standard Deviation: " + RoundToPlace(SD, "0.0000") + "\n");
        System.out.println(String.format("%-5s %-5s %7s" , "", "Grade", "Score"));
        for (int i = 0; i < Grades.length; i++) {
            System.out.println(
                String.format(
                    "%-5s %5s %5s",
                    i+1,
                    RoundToPlace(Grades[i], "0.00"),
                    GetCurvedGrade(Grades[i])
                )
            );
        }
        return "";
    }

    private String GetCurvedGrade(int grade){
        if(grade >= Mean + (1.5 * SD)){
            return "A";
        } else if(Mean + (0.5 * SD) <= grade && grade < Mean + (1.5 * SD)){
            return "B";
        } else if(Mean - (0.5 * SD) <= grade && grade < Mean + (0.5 * SD)){
            return "C";
        } else if(Mean - (1.5 * SD) <= grade && grade < Mean - (0.5 * SD)){
            return "D";
        } else if(grade < Mean - (1.5 * SD)){
            return "F";
        } else {
            return "";
        }
    }

    // Use DecimalFormatter to round a given number to a given template
    private String RoundToPlace(double number, String template){
        DecimalFormat df = new DecimalFormat(template);
        String formattedNumber = df.format(number);
        return formattedNumber;
    }
}


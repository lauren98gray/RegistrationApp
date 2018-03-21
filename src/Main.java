import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\n\nHello, RegistrationApp!\n\n");

        //Read and store the data from "curriculum.dat"
        ArrayList<String> curriculumLines = createListFromFileLines("curriculum.dat");

        //Output the data
        String outputCurriculum = formatCurriculumForOutput(curriculumLines);
        System.out.println("The curriculum is as follows:\n\n" + outputCurriculum);

        //Calculate the total hours in the curriculum
        int totalCurriculumHours = calculateTotalCurriculumHours(curriculumLines);
        System.out.println("The total number of hours in the curriculum is " + totalCurriculumHours);



    }

    private static String formatCurriculumForOutput(ArrayList<String> curriculumLines) {
        String output = "";
        for (String line : curriculumLines){
            output += line+ "\n";
        }
        return output;
    }

    private static ArrayList<Integer> getCreditHours(ArrayList<String> curriculumLines) {
        ArrayList<Integer> hours = new ArrayList<Integer>();
        for (String course : curriculumLines){
                hours.add(Integer.valueOf(course.substring(course.length()-1, course.length())));
        }
        return hours;
    }

    private static int calculateTotalCurriculumHours(ArrayList<String> curriculumLines) {
        ArrayList<Integer> hours = getCreditHours(curriculumLines);
        int sum = 0;
        for (int hour : hours) {
            sum += hour;
        }
        return sum;
    }

    private static ArrayList<String> createListFromFileLines(String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
            BufferedReader in = new BufferedReader(new FileReader(fileName));
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            lines.add(line);
        }
        return lines;
    }



}

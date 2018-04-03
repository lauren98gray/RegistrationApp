import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\n\nHello, RegistrationApp!\n\n");

        //The Curriculum

        //Read, store, and output the data from "curriculum.dat"
        Curriculum curriculum = new Curriculum("curriculum.dat");
        System.out.println("Curriculum:\n" + curriculum);

        //Calculate the total hours in the curriculum
        int totalCurriculumHours = curriculum.calculateTotalCurriculumHours();
        System.out.println( "The total number of hours in the curriculum is " + totalCurriculumHours + "." );

        //Count the number of [DEPT] courses
        String department = "CPSC";
        int numDEPTCourses = curriculum.countNumDEPTCourses(department);
        System.out.println("\nThere are " + numDEPTCourses + " " + department + " courses in the curriculum.");

        //Check if a course is in the curriculum
        String course = "CPSC 2740";
        boolean courseInCurriculum = curriculum.checkIfInCurriculum(course);
        if (courseInCurriculum){
            System.out.println("\n" + course + " is in the curriculum.");
        } else {
            System.out.println("\n" + course + " is not in the curriculum.");
        }

        //The Transcript

        //Read and store the data from "transcript.txt"
        Transcript transcript = new Transcript("transcript.txt");
        System.out.println("\n\nTranscript:\n" + transcript);




    }

    private static boolean checkIfInCurriculum(ArrayList<String> curriculumLines, String course) {
        int check = 0;
        for (String line : curriculumLines){
            if (line.substring(0,9).equals(course)){
                check = 1;
            }
        }
        return check == 1;
    }

    private static int countNumDEPTCourses(ArrayList<String> curriculum, String DEPT) {
        int count = 0;
        for (String line : curriculum){
            //if (line.substring(0,4).equals(DEPT)) {
            //this works so that the CPSC elective is also included
            if (line.contains(DEPT)){
                count++;
            }
        }
        return count;
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

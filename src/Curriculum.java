import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Curriculum {

    //instance variables
    private ArrayList<String> curriculumLines;

    //methods
    public Curriculum(String fileName) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            lines.add(line);
        }
        curriculumLines = lines;
    }

    @Override
    public String toString() {
        String output = "";
        for (String line : curriculumLines){
            output += line+ "\n";
        }
        return output;
    }

    public int calculateTotalCurriculumHours() {
        ArrayList<Integer> hours = new ArrayList<Integer>();
        for (String course : curriculumLines){
            hours.add(Integer.valueOf(course.substring(course.length()-1, course.length())));
        }
        int sum = 0;
        for (int hour : hours) {
            sum += hour;
        }
        return sum;
    }

    public int countNumDEPTCourses(String DEPT) {
        int count = 0;
        for (String line : curriculumLines){
            if (line.contains(DEPT)){
                count++;
            }
        }
        return count;
    }

    public boolean checkIfInCurriculum(String course){
        int check = 0;
        for (String line : curriculumLines){
            if (line.substring(0,9).equals(course)){
                check = 1;
            }
        }
        return check == 1;
    }




}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Transcript {

    //instance variables
    private ArrayList<Course> transcript;

    public Transcript(String fileName) throws FileNotFoundException {
        transcript = new ArrayList<Course>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String line = sc.nextLine();

            String[] details = line.split(" ");
            String dept = details[0];
            String number = details[1];
            int hours = Integer.parseInt(details[2]);
            transcript.add(new Course(dept, number, hours));
        }

    }

    @Override
    public String toString() {
        String output = "";
        for (Course line : transcript){
            output += line+ "\n";
        }
        return output;
    }

    public int calculateTotalHours(){
        int sum = 0;
        for (Course course : transcript){
            sum += course.getHours();
        }
        return sum;
    }

    public ArrayList<Course> getTranscript() {
        return transcript;
    }

    public Course getCourse(int index) {
        return transcript.get(index);
    }

    public boolean checkIfInCurriculum(Course transcriptCourse, Curriculum curriculum){
        if (curriculum.checkIfInCurriculum(transcriptCourse)){
            return true;
        }
        return false;
    }

    public boolean checkIfInTranscript(Course course) {
        for (Course course1 : transcript){
            if (course.equals(course1)){
                return true;
            }
        }
        return false;
    }

}

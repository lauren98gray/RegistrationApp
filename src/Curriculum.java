import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Curriculum {

    private ArrayList<Course> curriculum;


    public Curriculum(String fileName) throws FileNotFoundException {
        curriculum = new ArrayList<Course>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String line = sc.nextLine();

                String[] details = line.split(" ");
                String dept = details[0];
                String number = details[1];
                int hours = Integer.parseInt(details[2]);
                curriculum.add(new Course(dept, number, hours));
        }
    }


    @Override
    public String toString() {
        String output = "";
        for (Course line : curriculum){
            output += line+ "\n";
        }
        return output;
    }

    public int calculateTotalHours() {
        int sum = 0;
        for (Course course : curriculum){
            sum += course.getHours();
        }
        return sum;
    }

    public int countNumDEPTCourses(String DEPT) {
        int count = 0;
        for (Course course : curriculum){
            if (course.getDept().equals(DEPT)){
                count++;
            }
        }
        return count;
    }

    public boolean checkIfInCurriculum(Course course) {
        if (curriculum.contains(course)){
            return true;
        }else{
            return false;
        }
    }

    public Course getCourseInCurriculum(int index){
        return curriculum.get(index);
    }

}

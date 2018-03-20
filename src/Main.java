import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("\n\nHello, RegistrationApp!\n");

        //Read and store the data from "curriculum.dat"
        ArrayList<String> curriculumLines = createListFromFileLines("curriculum.dat");
        System.out.println(curriculumLines);


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

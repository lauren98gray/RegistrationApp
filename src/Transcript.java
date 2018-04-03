import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Transcript {

    //instance variables
    private ArrayList<String> transcriptLines;

    public Transcript(String fileName) throws IOException{
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        for (String line = in.readLine(); line != null; line = in.readLine()) {
            lines.add(line);
        }
        transcriptLines = lines;
    }

    @Override
    public String toString() {
        String output = "";
        for (String line : transcriptLines){
            output += line+ "\n";
        }
        return output;
    }
}

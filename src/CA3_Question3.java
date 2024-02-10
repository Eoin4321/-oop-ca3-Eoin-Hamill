import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  Name: Eoin Hamill
 *  Class Group: GD2A
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {
        int currentlinenum=0;
        String line;
        Map<String, Integer> question3 = new HashMap<>();
        //in.useDelimiter("[^A-Za-z0-9_]+");
        File file = new File(fileName);
        Scanner s = new Scanner(file);

        s.useDelimiter(("[^A-Za-z0-9_]+"));

        while(s.hasNextLine()) {
            currentlinenum++;
            line =s.nextLine();
            System.out.println(line);
            System.out.println("\nTest");


        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}

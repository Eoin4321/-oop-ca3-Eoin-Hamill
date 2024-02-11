import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
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
        //Setting up variables
        ArrayList<String> Identifiers = new ArrayList<>();

        int lineNumber=0;
        //Creating Map
        Map<String, String> question3 = new HashMap<>();

        //Creating scanner to read from file
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);


        //While loop which reads a new line
        while(scanner.hasNextLine())
        {
            lineNumber++;
            String line = scanner.nextLine();
            Scanner scanner2 = new Scanner(line);
            scanner2.useDelimiter("[^A-Za-z0-9_]+");

            while(scanner2.hasNext()) {
                String token = scanner2.next();

                if(!Identifiers.contains(token)){
                    Identifiers.add(token);
                }

                if(Identifiers.contains(token)) {
                    if(question3.get(token)==null) {
                        question3.put(token, Integer.toString(lineNumber));
                    }
                    else
                    {
                        String value=question3.get(token)+", "+lineNumber;
                        question3.put(token,value);
                    }
                }

            }

        }

        System.out.println(question3);
        }




    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}

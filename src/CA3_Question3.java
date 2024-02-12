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
        //Setting up array which contains Identifiers
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
            //scanner reads line
            String line = scanner.nextLine();
            //scanner 2 reads scanner line and splits it up
            Scanner scanner2 = new Scanner(line);
            //Using delimited to split up sentence
            scanner2.useDelimiter("[^A-Za-z0-9_]+");
            //while there are words left while loop runs
            while(scanner2.hasNext()) {
                //Setting string to equal word
                String token = scanner2.next();
                //If identifiers does not contain the word it will be added
                if(!Identifiers.contains(token)){
                    Identifiers.add(token);
                }
                //if it does contain the word
                if(Identifiers.contains(token)) {
                    //If the word has no index add the number
                    if(question3.get(token)==null) {
                        question3.put(token, Integer.toString(lineNumber));
                    }
                    //if the word does have an index add the extra index onto the old one
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

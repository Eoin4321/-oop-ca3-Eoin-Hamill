import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Eoin Hamill
 *  Class Group: GD2a
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        Stack<String> tags = new Stack<>();
        while(scanner.hasNext())
        {
            String tag = scanner.next();

            if(!tags.isEmpty())
            {
                System.out.println(tag);
                System.out.println("\n"+tags.peek().substring(0,1)+"/"+tag.substring(1));
            }
            if(!tags.isEmpty()&&(tags.peek().substring(0,1)+"/"+tags.peek().substring(1)).equals(tag))
            {
                tags.pop();
                System.out.println("This is the pop");
            }
            else
            {
                tags.push(tag);
            }

        }

        if(tags.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}

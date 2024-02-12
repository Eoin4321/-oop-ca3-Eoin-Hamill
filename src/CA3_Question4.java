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
        //reading file
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        //creating stack of Strings
        Stack<String> tags = new Stack<>();
        while(scanner.hasNext())
        {
            String tag = scanner.next();
            //Used this old code to check what was happening when running program
//            if(!tags.isEmpty())
//            {
//                System.out.println(tag);
//                System.out.println("\n"+tags.peek().substring(0,1)+"/"+tag.substring(1));
//            }
            //if tags is not empty and the tag matches.I check if the tag matches by adding a / to the one in the stack I remove the tag from the top of the stack
            if(!tags.isEmpty()&&(tags.peek().substring(0,1)+"/"+tags.peek().substring(1)).equals(tag))
            {
                tags.pop();
                //System.out.println("This is the pop");
            }
            //Otherwise I add it to the top of the stack
            else
            {
                tags.push(tag);
            }

        }
        //If tags is empty it means it is valided
        if(tags.isEmpty())
        {
            return true;
        }
        //Otherwise it is not valid
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

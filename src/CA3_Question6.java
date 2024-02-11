import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        //Setting up variables
        int quantityCount;
        double profit=0;
        Queue<Block> blocks = new LinkedList<>();
       Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
                System.out.println("Type in buy or sell");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.println("Enter amount you want to buy");
                int qty = in.nextInt();
                System.out.println("Enter the price you will be paying");
                double price = in.nextDouble();
                blocks.add(new Block(qty, price));

            }
            else if(command.equals("sell"))
            {
                profit=sellMethod(blocks);
                System.out.println("You made "+profit+" Euro");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

    public static double sellMethod(Queue<Block> blocks){
        Scanner in = new Scanner(System.in);
        double profit=0;
        System.out.println("Enter amount you want to sell");
        int qty = in.nextInt();
        System.out.println("Enter the price you will be paying");
        double price = in.nextDouble();
        System.out.println("Total profit " );
        while(qty>0|| !blocks.isEmpty())
        {
            if(qty>=blocks.peek().getQuantity()&!blocks.isEmpty())
            {
                profit=(profit+((blocks.peek().getQuantity()*price)-(blocks.peek().getQuantity()*blocks.peek().getPrice())));
                qty = qty-blocks.peek().getQuantity();
                blocks.poll();
            }
            //profit=(profit+((blocks.peek().getQuantity()*price)-(blocks.peek().getQuantity()*blocks.peek().getPrice())));
        }
        return profit;
    }
}
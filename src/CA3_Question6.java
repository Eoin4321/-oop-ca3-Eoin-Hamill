import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *  Name: Eoin
 *  Class Group: Hamill
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
        double profit=0;
        //Setting up queue using the Block class i created. This contains qty and price.
        Queue<Block> blocks = new LinkedList<>();
        //adding a scanner to take input
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
                System.out.println("Enter amount you want to sell");
                int qty = in.nextInt();
                System.out.println("Enter the price you will be paying");
                double price = in.nextDouble();
                boolean selling = true;
                while(selling==true)
                {
                    if(!blocks.isEmpty()) {
                        profit = (price - blocks.peek().getPrice()) + (profit);
                        qty = qty - 1;
                        blocks.peek().setQuantity(blocks.peek().getQuantity() - 1);
                    }
                    if(blocks.peek().getQuantity()==0)
                    {
                        blocks.poll();
                    }
                    if(qty==0)
                    {
                        selling=false;
                    }
                    if(blocks.isEmpty())
                    {
                        System.out.println("Remaining "+qty);
                        selling=false;
                    }

                }
                    //profit=(profit+((blocks.peek().getQuantity()*price)-(blocks.peek().getQuantity()*blocks.peek().getPrice())));

                System.out.println("You made "+profit+" Euro");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

    }

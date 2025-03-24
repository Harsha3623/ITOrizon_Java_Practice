
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ImplementedClass im= new ImplementedClass();

        /**
         * Menu for Order management system
         */
        while(true){
            System.out.println("------------------------------------");
            System.out.println("------Order Management System---------");
            System.out.println("----------------MENU------------------");
            System.out.println("------------------------------------");

            System.out.println("1--> Add Order");
            //completed
            System.out.println("2--> View Order");
            //completed
            System.out.println("3--> View By Order ID");
            //
            System.out.println("4--> Sort Order");
            //Todo In progress
            System.out.println("5--> Delete Order");
            //Todo
            System.out.println("6--> Mark as Delivered");
            //Todo
            System.out.println("7--> Cancel Order");
            //Todo
            System.out.println("8--> Generate Report");
            System.out.println("9--> Exit");
            //printing the hashset values
            for(String s: Order.hs){
                System.out.println(s);
            }
            //Order or = new Order();

            //Taking the user input
            System.out.println("Enter your choice");
            int input = sc.nextInt();
            switch (input){
                case 1:
                    im.addOrder();
                    break;
                case 2:
                    im.viewOrder();
                    break;
                case 3:
                    while(true) {
                        String ordId = sc.nextLine();
                        if (Order.hs.contains(ordId)) {
                            im.viewOrder(ordId);
                            break;
                        }else{
                            System.out.println("Enter a valid Order ID ");
                            continue;
                        }
                    }
                    break;
                case 4:
                    im.sortOrder();
                    break;
                case 5:
                    im.deleteOrder();
                    break;
                case 6:
                    //Todo mark as delivered
                    im.markDelivered();
                    break;
                case 7:
                    im.cancelOrder();
                    break;
                case 8:

                    break;
                case 9:
                    im.exit();
                    break;
                default:
                    System.out.println("Please enter a valid number in the menu!...");
            }
        }






    }

}
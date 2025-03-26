import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ImplementedClass im= new ImplementedClass();

        /*
          Menu for Order management system
         */
        outer: while(true){
            System.out.println("--------------------------------------");
            System.out.println("------Order Management System---------");
            System.out.println("--------------MENU--------------------");
            System.out.println("--------------------------------------");

            System.out.println("1--> Add Order");
            //completed
            System.out.println("2--> View Order");
            //completed
            System.out.println("3--> View By Order ID");
            //completed
            System.out.println("4--> Sort Order");
            //completed
            System.out.println("5--> Delete Order");
            //Completed
            System.out.println("6--> Mark as Delivered");
            //completed
            System.out.println("7--> Cancel Order");
            //completed
            System.out.println("8--> Generate Report");

            System.out.println("9--> Exit");

            System.out.println("Enter your choice");

            int input;
            //for handling the input mismatch exception
            // so if a user enters any other value then it will continue again
            try {
                input = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Enter a proper value");
                sc.nextLine();
                continue;
            }
            switch (input){
                case 1:
                    im.addOrder();
                    break;
                case 2:
                    im.viewOrder();
                    break;
                case 3:
                    while(true) {
                        System.out.println("Enter a order id:");
                        String ordId = sc.nextLine();
                        if (Order.hs.contains(ordId)) {
                            im.viewOrder(ordId);
                            break;
                        }else{
                            System.out.println("Enter a valid Order ID ");
                            //continue;
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
                    im.markDelivered();
                    break;

                case 7:
                    im.cancelOrder();
                    break;

                case 8:
                    im.generateReport();
                    break;

                case 9:
                    im.exit();
                    break outer;
                default:
                    System.out.println("Please enter a valid number in the menu!...");
            }
        }

    }

}
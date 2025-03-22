import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

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
            //TODO
            System.out.println("4--> Sort Order");
            //Todo In progress
            System.out.println("5--> Delete Order");
            //completed
            System.out.println("6--> Mark as Delivered");
            //completed
            System.out.println("7--> Cancel Order");
            //TODO
            System.out.println("8--> Generate Report");
            System.out.println("9--> Exit");
            Order or = new Order();

            //Taking the user input
            System.out.println("Enter your choice");
            int input = sc.nextInt();
            switch (input){
                case 1:
//                    or.addOrder();
                    AddOrderVerifier();
                    break;
                case 2:
                    or.viewOrder();
                    break;
                case 3:
                    sc.nextLine();
                    while(true) {
                        System.out.println("Enter the Order ID: ");
                        String orderId = sc.nextLine();
                        if (doesFileContainsOrderId(orderId)) {
                            or.viewOrder(orderId);
                            break;
                        } else {
                            System.out.println("Enter a valid orderID..");
                            continue;
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    or.deleteOrder();
                    break;
                case 6:
                    or.markDelivered();
                    break;
                case 7:
                    or.cancelOrder();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Please enter a valid number in the menu!...");
            }
        }






    }



    //implementing AddOrderVerifier() method
    private static void AddOrderVerifier() {
        //sc.nextLine();
        while(true) {
            sc.nextLine();
            System.out.println("Enter orderId");
            String ordId = sc.nextLine();

            //Check whether theorder id is present in the file or not
            if (doesFileContainsOrderId(ordId)) {
                //the order id is present in the file

                    System.out.println("The order id is already exists");
                    continue;
            }  else {
                System.out.println("Enter order description");
                String ordDes = sc.nextLine();
                System.out.println("Enter delivery address");
                String deliAdd = sc.nextLine();
                System.out.println("enter the amount");
                double amount = sc.nextDouble();
                if (ordDes.isEmpty() || deliAdd.isEmpty() || amount < 0.0) {
                    System.out.println("Please enter the valid Values");
                    continue;
                } else {
//                    //Adding the recquired space for the strings
//                    if(ordId.length()<10){
//                        ordId=addRecquiredSpace(ordId,10);
//                    }

                    //if()
                    Order or = new Order();
                    or.addOrder(ordId, ordDes, deliAdd, amount);
                    //the order id is not present in the file

                    System.out.println("Order" + " added Successfully..");
                }
            }
            System.out.println("Do you want to enter more order details(Y/N) ");
            char ch = sc.next().charAt(0);
            if(ch=='Y'||ch=='y'){
                continue;
            }else if(ch=='N'||ch=='n'){
                break;
            }
        }


    }

    private static String addRecquiredSpace(String str, int i) {
        for(int num=str.length();num<i;num++){
            str=str+" ";
        }
        return str;
    }

    //implementing checking condition whather the order id is present in the file
    //or not
     static boolean doesFileContainsOrderId(String ordId) {
        boolean contains=false;
        String filePath = "C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";

        //file reader
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=reader.readLine())!=null){
                String[] data = line.split(",");
                if(data.length>0 && (data[0].trim()).equals(ordId)){
                    contains=true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contains;
    }
}
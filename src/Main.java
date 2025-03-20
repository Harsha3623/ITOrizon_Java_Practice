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
        System.out.println("------------------------------------");
        System.out.println("------Order Management System---------");
        System.out.println("----------------MENU------------------");
        System.out.println("------------------------------------");
        while(true){
            System.out.println("1--> Add Order");
            System.out.println("2--> View Order");
            System.out.println("3--> View By Order ID");
            System.out.println("4--> Sort Order");
            System.out.println("5--> Delete Order");
            System.out.println("6--> Mark as Delivered");
            System.out.println("7--> Cancel Order");
            System.out.println("8--> Generate Report");
            System.out.println("9--> Exit");
            //Order or = new Order();

            //Taking the user input
            System.out.println("Enter your choice");
            int input = sc.nextInt();
            switch (input){
                case 1:
//                    or.addOrder();
                    AddOrderVerifier();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
    //implimenting AddOrderVerifier() method
    private static void AddOrderVerifier() {
        sc.nextLine();
        while(true) {
            System.out.println("Enter orderId");
            String ordId = sc.nextLine();
            System.out.println("Enter order description");
            String ordDes = sc.nextLine();
            System.out.println("Enter delivery address");
            String deliAdd = sc.nextLine();
            System.out.println("enter the amount");
            double amount = sc.nextDouble();

            //Check whether theorder id is present in the file or not
            if (doesFileContainsOrderId(ordId)) {
                //the order id is present in the file

                    System.out.println("The order id is already exists");
                    continue;
            } else {
                if (ordDes.isEmpty() || deliAdd.isEmpty() || amount < 0.0) {
                    System.out.println("Please enter the valid Values");
                } else {
                    Order or = new Order();
                    or.addOrder(ordId, ordDes, deliAdd, amount);
                    //the order id is not present in the file

                    System.out.println("Order" + " added to the File");
                }
            }
            System.out.println("Do you want to enter more order details(Y/N) ");
            char ch = sc.next().charAt(0);
            if(ch=='Y'){
                continue;
            }else{
                break;
            }
        }


    }

    //implementing checking condition whather the order id is present in the file
    //or not
    private static boolean doesFileContainsOrderId(String ordId) {
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
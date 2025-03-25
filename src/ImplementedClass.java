import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ImplementedClass  implements OrderManagement{
    //Scanner class
    Scanner sc = new Scanner(System.in);

    @Override
    public void addOrder() {
        Order or = new Order();
    }


    //todo format the data in a proper manner
    @Override
    public void viewOrder() {
    ArrayList<Order> array = Order.arr;
        array.sort(Comparator.comparing(order -> order.getOrderId()));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Order Id | Order Description  |    Delivery Address     |     Order Date     |  Amount  |   Delivery Date    |   Status  |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

            for (Order order : array) {
                System.out.println(order.toString());
//                System.out.print(order.getOrderId()+" | ");
//                System.out.print(order.getOrderDescription()+" | ");
//                System.out.print(order.getDeliveryAddress()+" | ");
//                System.out.print(order.getOrderDate()+" | ");
//                System.out.print(order.getAmount()+" | ");
//                System.out.print(order.getDeliveryDate()+" | ");
//                System.out.print(order.getStatus()+" | ");
//                System.out.println();
            }
        System.out.println("\n\n");


        }

    //method overloading for view order by id and view order
    //todo format the data in a proper manner
    @Override
    public void viewOrder(String orderID) {
        ArrayList<Order> array=Order.arr;
        System.out.println("Order Details: ");
        for(Order order: array){
            if(order.getOrderId().equals(orderID)){
                System.out.println("Order ID: "+order.getOrderId());
                System.out.println("Order Description: "+order.getOrderDescription());
                System.out.println("Order Delivery Address: "+order.getDeliveryAddress());
                System.out.println("Order Date: "+order.getOrderDate());
                System.out.println("Order Amount: "+order.getAmount());
                System.out.println("Order Delievry Date: "+order.getDeliveryDate());
                System.out.println("Order Sataus: "+order.getStatus());
                System.out.println();
                break;
            }
        }
        System.out.println("\n\n");

    }

    @Override
    public void markDelivered() {
        //sc.nextLine();
        outer: while(true){
            //sc.nextLine();
            System.out.println("Enter a valid order id: ");
            //sc.nextLine();
            String ordId = sc.nextLine();
            if(Order.hs.contains(ordId)){
                for(Order order: Order.arr){
                    //ifOrder Id equals to array list order id
                    if(order.getOrderId().trim().equals(ordId)){
                        if((order.getStatus().trim()).equals("Cancelled")){
                            System.out.println("The order cannot be delivered it is cancelled by the user..");
                            break;
                        }else if((order.getStatus().trim()).equals("Delivered")){
                            System.out.println("The order is already delivered and cannot deliver again.");
                            break;
                        }else {
                            order.setStatus("Delivered");
                            LocalDateTime curDate = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH-mm-ss");
                            String currentDate = curDate.format(formatter);
                            order.setDeliveryDate(currentDate);
                            System.out.println("The order is delivered to the customer..");
                            break;
                        }
                    }
                }
                System.out.println("Do you want to mark another Order as Delivered(Y/N)");
                //char ch = sc.nextLine().charAt(0);
                while(true) {
                    char ch = sc.nextLine().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        //sc.nextLine();
                        continue outer;
                    } else if (ch == 'n' || ch == 'N') {
                        break outer;
                    } else {
                        System.out.println("please enter either Yes or no option..");
                        continue;
                    }
                }
            }else{
                System.out.println("Please enter a valid order ID..");
                continue;
            }
        }

    }

    @Override
    public void cancelOrder() {
        outer: while(true){
            System.out.println("enter valid order id: ");
            String orderId = sc.nextLine();
            if(Order.hs.contains(orderId)){
                for(Order order: Order.arr){
                    if((order.getOrderId().trim()).equals(orderId)){
                        if(!(order.getStatus().trim()).equals("Cancelled")){
                        order.setStatus("Cancelled");
                        String str = null;
                        order.setDeliveryDate(str);
                            System.out.println("The order has been cancelled successfully.");
                        }else {
                            System.out.println("Order has been already cancelled.");

                        }
                    }
                }
                while(true){
                    System.out.println("Do you want to cancel another Order(Y/N)");
                    char ch = sc.nextLine().charAt(0);
                    if(ch=='Y'||ch=='y'){
                        continue outer;
                    }else if(ch=='n'||ch=='N'){
                        break outer;
                    }else {
                        System.out.println("Please enter either yes(Y) or NO(N) option.");
                    }
                }
            }else{
                System.out.println("Plase enter a valid order id to cancel the order.");
                continue;
            }
        }
    }

    @Override
    public void deleteOrder() {
        outer: while (true){
            System.out.println("Enter a valid order id for deleting the order:");
            String orderId = sc.nextLine();
            if(Order.hs.contains(orderId)){
                for(Order order: Order.arr){
                    if((order.getOrderId().trim()).equals(orderId)){
                        Order.arr.remove(order);
                        System.out.println("The order has been removed successfully");
                        //need to remove the order id from hash set for better usage after deleting
                        //in the array list
                        Order.hs.remove(orderId);
                        break;
                    }
                }
                while (true){
                    System.out.println("Do you want to delete another order(Y/N)");
                    char ch = sc.nextLine().charAt(0);
                    if(ch=='Y'|| ch=='y'){
                        continue outer;
                    } else if (ch=='N'||ch=='n') {
                        break outer;
                    }else {
                        System.out.println("Enter either yes or no option..");
                    }
                }
            }else{
                System.out.println("The order id is not present in the orders. enter valid order id.");
            }
        }
    }

    @Override
    public void exit() {

        //Todo Update the file path to the actual file path
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Harsha\\IdeaProjects\\Order Management System 2\\src\\Order_Transaction.txt"))){
        for(Order order: Order.arr){
            writer.write(order.getOrderId()+","+order.getOrderDescription()+","+
                    order.getDeliveryAddress()+","+order.getOrderDate()+","+order.getAmount()+
                    ","+order.getDeliveryDate()+","+order.getStatus());
            writer.newLine();

        }
        writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortOrder() {
        outer: while(true) {
            System.out.println("----------Chose Sort Order property---------");
            System.out.println("1--> OrderID");
            System.out.println("2--> Order Description");
            System.out.println("3--> Delivery Address");
            System.out.println("4--> Order Date");
            System.out.println("5--> Amount");
            System.out.println("6--> Delivery Date Time ");
            System.out.println("7--> Exit");
            int n,number = 0;
            try {
                n = sc.nextInt();
                sc.nextLine();
                if(n==7){
                    break outer;
                }
                number=n;
                
            }catch (InputMismatchException e){
                System.out.println("Enter a Integer value.");
                sc.nextLine();
                continue outer;
            }
            int ascOrDesc;
            while(true) {
                System.out.println("----------Chose Sort Order property---------");
                System.out.println("1--> Ascending");
                System.out.println("2--> Descending");
                int sortOrder;
                //handling input mismatch exception
                try {
                    sortOrder = sc.nextInt();
                    sc.nextLine();
                    if(sortOrder==1| sortOrder==2){
                        ascOrDesc=sortOrder;
                        break;
                    }else {
                        System.out.println("enter a either 1 or 2");
                        continue;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Enter Integer Value .");
                    sc.nextLine();
                }
                
            }
            //creating the local array list for sorting purpose
            ArrayList<Order> array = Order.arr;
            //todo minimise it
            switch (number){
                case 1:
                    //sortBasedOnStatus(array,"OrderId",ascOrDesc);
                    if(ascOrDesc==1) {
                        array.sort(Comparator.comparing(order -> order.getOrderId()));
                    }else{
                        array.sort(Comparator.comparing((Order order) -> order.getOrderId()).reversed());
                    }
                    viewOrder(array);
                    break;
                    //break;
                case 2:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getOrderDescription()));
                    }else {
                        array.sort(Comparator.comparing((Order order) -> order.getOrderDescription()).reversed());
                    }
                    viewOrder(array);
                    break;
                case 3:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getDeliveryAddress()));
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getDeliveryAddress()).reversed());
                    }
                    viewOrder(array);
                    break;
                case 4:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getOrderDate()));
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getOrderDate()).reversed());
                    }
                    viewOrder(array);
                    break;
                case 5:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparingDouble(order -> order.getAmount()));
                    }else{
                        array.sort(Comparator.comparingDouble((Order order) ->order.getAmount()).reversed());
                    }
                    viewOrder(array);
                    break;
                case 6:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getDeliveryDate()));
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getDeliveryDate()).reversed());
                    }
                    viewOrder(array);
                    break;

                default:
                    System.out.println("Enter a proper value ");
                    continue;
                    //throw new IllegalStateException("Unexpected value: " + number);
            }

        }
    }

    @Override
    //view order for sorting option
    //todo format the data in a proper manner
    public void viewOrder(ArrayList<Order> array){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Order Id | Order Description  |    Delivery Address     |     Order Date     |  Amount  |   Delivery Date    |   Status  |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        for (Order order : array) {
            System.out.println(order.toString());
//            System.out.print(order.getOrderId()+" | ");
//            System.out.print(order.getOrderDescription()+" | ");
//            System.out.print(order.getDeliveryAddress()+" | ");
//            System.out.print(order.getOrderDate()+" | ");
//            System.out.print(order.getAmount()+" | ");
//            System.out.print(order.getDeliveryDate()+" | ");
//            System.out.print(order.getStatus()+" | ");
//            System.out.println();
        }
        System.out.println("\n\n");
    }


    public void generateReport() {
        while(true) {
            System.out.println("-------------Choose Report Generation Option-----------");
            System.out.println("1--> Export All");
            System.out.println("2--> By Status");
            System.out.println("3-->exit");
            int number = sc.nextInt();
            if(number==3){
                break;
            }
            FileWritng fw;
            switch (number){
                case 1:
                    //for exporting all the orders to the report
                    //sorting based on the order id and then generating the report
                    ArrayList<Order> array = Order.arr;
                    array.sort(Comparator.comparing(order -> order.getOrderId()));
                    fw = new FileWritng(array);
                    //starting the thread
                    fw.start();
                    try {
                        //waiting for the process to complete
                        fw.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    //based on status
                    System.out.println("-------------Choose Report Generation Option-----------");
                    System.out.println("1--> In Progress");
                    System.out.println("2--> Delivered");
                    System.out.println("3--> Cancelled");
                    int choice = sc.nextInt();
                    //for storing the orders based on the user input
                    ArrayList<Order> arrayByStatus;
                    switch (choice){
                        case 1: arrayByStatus=sortBasedOnStatus(Order.arr,"In Progress");

                            //sorting the based on orderId
                            //arrayByStatus.sort(Comparator.comparing(order -> order.getOrderId()));

                            //calling the thread for report generation
                            fw = new FileWritng(arrayByStatus);
                            //starting the file
                            fw.start();

                            try {
                                //waiting for the processs to complete
                                //the process--> writing content to the file
                                fw.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            arrayByStatus = sortBasedOnStatus(Order.arr,"Delivered");

                            //sorting the based on orderId
                            //arrayByStatus.sort(Comparator.comparing(order -> order.getOrderId()));
                            //calling the thread for report generation
                            fw = new FileWritng(arrayByStatus);
                            //starting the thread
                            fw.start();

                            try {
                                //waiting until the file writing process completes
                                fw.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 3:
                            arrayByStatus = sortBasedOnStatus(Order.arr,"Cancelled");

                            //sorting the based on orderId
                            //arrayByStatus.sort(Comparator.comparing(order -> order.getOrderId()));
                            //calling the thread for report generation
                            fw = new FileWritng(arrayByStatus);
                            //start the thread
                            fw.start();

                            try {
                                //waiting until the process completes
                                fw.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        default:
                            System.out.println("Enter a correct value.");
                    }
                    break;

                default:
                    System.out.println("enter a proper value.");;
            }
        }
    }

    private ArrayList<Order> sortBasedOnStatus(ArrayList<Order> arr, String str) {
        ArrayList<Order> array = new ArrayList<>();
        for(Order order: arr){
            if(order.getStatus().trim().equals(str)){
                array.add(order);
            }
        }
        //sorting based on order id
        array.sort(Comparator.comparing(order -> order.getOrderId()));
        return array;
    }

}

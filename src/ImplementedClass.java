import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
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
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Order Id| order Description| Delivery Address | OrderDate | Amount| Delivery Date| Status");
        System.out.println("-----------------------------------------------------------------------------------------");

            for (Order order : array) {
                System.out.print(order.getOrderId()+" | ");
                System.out.print(order.getOrderDescription()+" | ");
                System.out.print(order.getDeliveryAddress()+" | ");
                System.out.print(order.getOrderDate()+" | ");
                System.out.print(order.getAmount()+" | ");
                System.out.print(order.getDeliveryDate()+" | ");
                System.out.print(order.getStatus()+" | ");
                System.out.println();
            }


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

    }

    @Override
    public void markDelivered() {
        outer: while(true){
            System.out.println("Enter a valid order id: ");
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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Harsha\\Desktop\\testingfile.txt"))){
        for(Order order: Order.arr){
            writer.write(order.toString());
            writer.newLine();

        }
        writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortOrder() {
        outer: while(true){
            System.out.println("----------Chose Sort Order property---------");
            System.out.println("1--> OrderID");
            System.out.println("2--> Order Description");
            System.out.println("3--> Delivery Address");
            System.out.println("4--> Order Date");
            System.out.println("5--> Amount");
            System.out.println("6--> Delivery Date Time ");
            System.out.println("7--> Exit");
            int number = sc.nextInt();
            if(number==7){
                break outer;
            }
            int ascOrDesc;
            while(true) {
                System.out.println("----------Chose Sort Order property---------");
                System.out.println("1--> Ascending");
                System.out.println("2--> Descending");

                int sortOrder = sc.nextInt();
                if(sortOrder==1| sortOrder==2){
                    ascOrDesc=sortOrder;
                    break;
                }else {
                    System.out.println("enter a either 1 or 2");
                    continue;
                }
            }
            //creating the local array list for sorting purpose
            ArrayList<Order> array = Order.arr;

            switch (number){
                case 1:
                    if(ascOrDesc==1) {
                        array.sort(Comparator.comparing(order -> order.getOrderId()));

                        viewOrder(array);
                        break;
                    }else{
                        array.sort(Comparator.comparing((Order order) -> order.getOrderId()).reversed());

                        viewOrder(array);
                        break;
                    }
                case 2:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getOrderDescription()));
                        viewOrder(array);
                        break;
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getOrderDescription()).reversed());
                        viewOrder(array);
                        break;
                    }
                case 3:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getDeliveryAddress()));
                        viewOrder(array);
                        break;
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getDeliveryAddress()).reversed());
                        viewOrder(array);
                        break;
                    }
                case 4:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getOrderDate()));
                        viewOrder(array);
                        break;
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getOrderDate()).reversed());
                        viewOrder(array);
                        break;
                    }
                case 5:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparingDouble(order -> order.getAmount()));
                        viewOrder(array);
                        break;
                    }else{
                        array.sort(Comparator.comparingDouble((Order order) ->order.getAmount()).reversed());
                        viewOrder(array);
                        break;
                    }
                case 6:
                    if(ascOrDesc==1){
                        array.sort(Comparator.comparing(order -> order.getDeliveryDate()));
                        viewOrder(array);
                        break;
                    }else{
                        array.sort(Comparator.comparing((Order order) ->order.getDeliveryDate()).reversed());
                        viewOrder(array);
                        break;
                    }

                default:
                    throw new IllegalStateException("Unexpected value: " + number);
            }

        }
    }

    //view order for sorting option
    //todo format the data in a proper manner
    public void viewOrder(ArrayList<Order> array){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Order Id| order Description| Delivery Address | OrderDate | Amount| Delivery Date| Status");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (Order order : array) {
            System.out.print(order.getOrderId()+" | ");
            System.out.print(order.getOrderDescription()+" | ");
            System.out.print(order.getDeliveryAddress()+" | ");
            System.out.print(order.getOrderDate()+" | ");
            System.out.print(order.getAmount()+" | ");
            System.out.print(order.getDeliveryDate()+" | ");
            System.out.print(order.getStatus()+" | ");
            System.out.println();
        }
    }



}

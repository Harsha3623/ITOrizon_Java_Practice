import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Order implements OrderManagement{
    private String orderId;
    private String orderDescription;
    private String deliveryAddress;
    private String orderDate;
    private double amount;
    private String status;
    private String deliveryDate;

    final String filePath = "C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";

    //scanner
    Scanner sc = new Scanner(System.in);

    //TODO implementing the buffered writer to the file writing
    @Override
    public void addOrder(String ordId, String ordDes, String deliAdd, double amount) {

        //Assigning values to the variables
        this.orderId=ordId;
        this.orderDescription=ordDes;
        this.deliveryAddress=deliAdd;
        this.amount=amount;
        status="In Progress";
        //Getting the current time and date
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime delDate = currentDate.plusDays(5);

        //formatting date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        orderDate = currentDate.format(formatter);
        deliveryDate = delDate.format(formatter);

        //Order data
        //TODO Format String while reporting
        //String format for the recquired space within the document
        //String orderData = String.format("%-15s || %-25s || %-30s || %-20s || %-10.2f || %-20s"
        //        ,orderId,orderDescription,deliveryAddress,orderDate,this.amount,deliveryDate);
        String orderData = orderId+", "+orderDescription+", "+deliveryAddress+", "+orderDate+", "+this.amount+", "+deliveryDate+", "+status;
        //String filePath = "C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";
        try(FileWriter fileWriter = new FileWriter(filePath,true)) {
            fileWriter.write(System.lineSeparator()+orderData);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void viewOrder() {

        //initialising the file path for reading the file
        //String filePath = "C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("| Order ID  |  Order Desc  | Delivery Address  | Order Date   | Amount  | Delivery Date  |");
        System.out.println("------------------------------------------------------------------------------------------");
        try(BufferedReader bufferedReader = new BufferedReader((new FileReader(filePath)))){
            String line;
            while((line=bufferedReader.readLine())!=null){
                String data = line.replaceAll(",","|");
//                for (String i: data) {
//                    System.out.print(i + "  | ");
//                }
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //getting the user input for order id
    public String getOrderId() {
        System.out.println("Enter a order id: ");
        //sc.nextLine();
        orderId=sc.nextLine();
        if(!Main.doesFileContainsOrderId(orderId)){
            System.out.println("The order id is not available..");
            System.out.println("Please enter a order id that is valid..");

            getOrderId();
        }else {
            return orderId;
        }

        return orderId;
    }


    //view the order List by Order ID given by the user
    //Method Overloading for view order
    @Override
    public void viewOrder(String orderID) {
        this.orderId=orderID;
        //orderId=getOrderId();
        System.out.println("-----------------------");
        System.out.println("Order Details: ");
        System.out.println("-----------------------");
        //String filePath = "C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line=reader.readLine())!=null){
                String data[] = line.split(",");
                if(data[0].equals(orderId)){
                    System.out.println("OrderID: "+data[0]);
                    System.out.println("Order Desc: "+ data[1]);
                    System.out.println("Delivery Address: "+data[2]);
                    System.out.println("Order Date: "+data[3]);
                    System.out.println("Amount: "+ data[4]);
                    System.out.println("Delivery DateTime: "+data[5]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void markDelivered() {
        //taking the order id from the user
        orderId=getOrderId();

        List<String> lines = new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line=reader.readLine())!=null){
                String[] data = line.split(",");
                if(data[0].equals(orderId)){
                    //getting current date and time
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    data[5]= currentDateTime.format(formatter);
                    data[6]="Delivered";
                    line="";
                    for(int i=0;i<data.length-1;i++){
                        line= line + data[i]+", ";
                    }
                    line=line+data[data.length-1];
                    lines.add(line);
                }else {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //writing back to the file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(String str:lines){
                writer.write(str);
                writer.newLine();
            }
            //updated successfully
            System.out.println("The order has been delivered");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //Cancelling orders from the user input
    @Override
    public void cancelOrder() {
        orderId=getOrderId();
        if(orderisCancelled(orderId)){
            System.out.println("Order is already cancelled");
        }else {
            //forStoring the Data which is present in the file
            List<String> list = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[0].equals(orderId)) {
                        // making the order has been cancelled
                        data[6] = "Cancelled";
                        data[5] = null;
                        line = (Arrays.toString(data)).replaceAll("[\\[\\]]", "");
                    }
                    list.add(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //writing back to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String s : list) {
                    writer.write(s);
                    writer.newLine();
                }
                System.out.println("Order is cancelled successfully..");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //Deleting the order from the file
    @Override
    public void deleteOrder() {
        //here itselef verfing that wheather the order id is available or not
        //for further processing of the data
        while(true) {
            orderId = getOrderId();
            List<String> list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if ((data[0].trim()).equals(orderId)) {
                        continue;
                    }else {
                        list.add(line);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //writing back to file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String str : list) {
                    writer.write(str);
                    writer.newLine();
                }
                System.out.println("Order deleted successfully..");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Do you want to delete another order? (Y/N) ");
            char ch = sc.nextLine().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                continue;
            } else {
                break;
            }
        }
    }

    //for verifing that whether the order is cancelled or not
    private boolean orderisCancelled(String orderId) {
        try(BufferedReader reader  = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line=reader.readLine())!=null){
                String[] data = line.split(",");
                if((data[0].trim()).equals(orderId) && (data[6].trim()).equals("Cancelled")){
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

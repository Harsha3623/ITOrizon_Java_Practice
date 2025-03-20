import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Order implements OrderManagement{
    private String orderId;
    private String orderDescription;
    private String deliveryAddress;
    private Date orderDate;
    private double amount;
    private String status;
    private Date deliveryDate;

    //scanner
    Scanner sc = new Scanner(System.in);

    @Override
    public void addOrder(String ordId, String ordDes, String deliAdd, double amount) {
        //Getting the current time and date

        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime deliveryDate = currentDate.plusDays(5);

        //formatting date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurDate = currentDate.format(formatter);
        String formattedDelDate = deliveryDate.format(formatter);

        //Order data

    String orderData = ordId+", "+ordDes+", "+deliAdd+", "+", "+formattedCurDate+", "+amount+", "+formattedDelDate;
    String filePath = "C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";
    try(FileWriter fileWriter = new FileWriter(filePath,true)) {
        fileWriter.write(System.lineSeparator()+orderData);


    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    }
}

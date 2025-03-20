import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextFileEdit {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time in a readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Print the local date and time
        System.out.println("Current Local Date and Time: " + formattedDateTime);
//        Path filePath = Paths.get("localtime.txt");
//        try{
//            //write to file
//            Files.writeString(filePath,formattedDateTime);
//            System.out.println("Date and time written to file: "+filePath);
//        }catch (IOException e){
//            System.out.println("An error occurred");
//        }

        String fileName="C:\\Users\\Harsha\\IdeaProjects\\Order Management System\\src\\localtime.txt";
        try(FileWriter writer = new FileWriter(fileName)){
        writer.write(formattedDateTime);
            System.out.println("Time has been written to file : "+fileName);
        }catch (IOException e){
            System.out.println("An Error Occured "+ e.getMessage());
        }
    }

}

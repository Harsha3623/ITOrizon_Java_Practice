
import java.util.Scanner;

public class SelectionStements {
    public static void main(String[] args) {
        int num=100;
        if(num==100){
            System.out.println("Number is equal to 100");
        }else{
            System.out.println("Number is not equal to 100");
        }
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){
            System.out.println("The number you provided is equal to 0");
        }else if(n<100){
            System.out.println("The number you provided is less than 100");
        }else {
            System.out.println("The number you provided is greater than 100");
        }

        System.out.println("The result decider.. \nEnter the marks of the student");
        int marks = sc.nextInt();
        if(marks<=35){
            System.out.println("Failed in exam");
        }else if(marks>35 && marks<50){
            System.out.println("Scored B grade");
        }else if (marks>=50 && marks<=80){
            System.out.println("Scored A grade");
        }else {
            System.out.println("Scored distinction");
        }
    }
}

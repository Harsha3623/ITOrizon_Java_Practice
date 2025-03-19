import java.util.Scanner;

/**
 * @author Harsha
 * version 1.0
 */
public class Time {
    /**
     * Program to find the timne ad greetings using user input
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour=sc.nextInt();
        if(hour>=0 && hour<12){
            System.out.println("Good morning");
        }else if(hour<=12 && hour<15){
            System.out.println("Good Afternoon");
        } else if (hour>=15 && hour<=18) {
            System.out.println("Good Evening");
        }else{
            System.out.println("Good night");
        }

        /*
        using switch statement finding the day
         */
        int day = sc.nextInt();
        System.out.println("Enter a day number ");
        switch (day){
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            case 1:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Enter a correct value");
        }
    }
}

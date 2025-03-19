import java.util.Scanner;

public class CodingChallenge2 {
    public static void main(String[] args) {
        /*
        using  pre-decrement operator in
        while's boolean_expression to print HELLO 5 times on to the console.
         */
        int number= 0;
        while((number++)<5){
            System.out.println("HELLO");
        }


        /*
        Write a program to calculate
        the sum of the numbers from 1 till upper bound.
         */
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),sum=0;
        while(n!=0){
            sum+=n;
            n--;
        }
        System.out.println(sum+"");

        /*
        Write a program using while loop to print Even numbers from 1 to 100.
         */
        int n2=0;
        while((n2++)<100){
            if(n2%2==0){
                System.out.println(n2);
            }
        }
        /*
        Write a program for following logic:
        Print all the odd numbers in comma separated form from 1 till end

         */

        int n3 = sc.nextInt(),n4=0;
        while(n4<=n3) {
            if(n4%2!=0){
                if(n4<n3-1){
                    System.out.print(n4+", ");
                }else{
                    System.out.print(n4);
                }
            }
            n4++;
        }
    }
}

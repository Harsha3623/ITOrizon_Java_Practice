import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        /**
         * one dimensional array representation
         * initally array is created in two ways either create and then assign
         * or intialize with the size at the initial stage itself
         */

        int[] arr = new int[5];
        /*
        initally the array is filled with intial values of the datatypes
         */
        System.out.println("\n\nBefor assigning the value");
        for(int i: arr){
            System.out.println(i);
        }
        System.out.println("\n\nAfter assigning the value");

        /**
         * asiigning values to the array
         */

        for(int i=1;i<=arr.length;i++){
            arr[i-1]=i;
        }
        /**
         * Iterating through the array
         */
        for(int i: arr){
            System.out.println(i);
        }

        //This type of initialization gives error dont assign size along with elements
        //int[] arr2 = new int[4] {1,2,3,4};

        /**
         * Coding challenge 5
         */

        /**
         *Write a Java Program to store numbers from 1 to 1000 in One-dimensional array and then print array contents as follows (10 elements per row):
         * 1    2    3    4    5    6    7    8    9    10
         * 11    12    13    14    15    16    17    18    19    20
         * 21    22    23    24    25    26    27    28    29    30
         * .
         * .
         * .
         * 991    992    993    994    995    996    997    998    999    1000
         */

        int [] arr2  = new int[1000];
        for(int i=1;i<=arr2.length;i++){
            arr2[i-1]=i;
        }

        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
            if((arr2[i]%10)==0){
                System.out.println();
            }
        }

        /**
         * Below is One-dimensional array code:
         * char arr [] = new char[] {'A', 'Z', 'B', 'N', 'P', 'T', 'X', 'C'};
         *
         * Write the code to search for particular character in above array.
         * If I search for 'B', then output should be: "B found!"
         * If I search for 'E', then output should be: "E Not found!"
         */

        char arr3 [] = new char[] {'A', 'Z', 'B', 'N', 'P', 'T', 'X', 'C'};

        Scanner sc = new Scanner(System.in);
        char ch = sc.nextLine().charAt(0);
        boolean found=false;
        for(char c: arr3){
            if(c==ch){

                found=true;
                break;
            }
        }
        if(found){
            System.out.println(ch+ " found!");
        }else{
            System.out.println(ch+ " not found!");
        }

        /**
         * short [] scores = {51, 85, 32, 0, 98, 157, 82, 101, 64, 249};
         * Above array stores the scores of a batsman in his last 10 innings in the game of cricket.
         * To know more about cricket, you can visit Wikipedia link: https://en.wikipedia.org/wiki/Cricket
         * If score is greater than or equal to 50 but less than 100, it is regarded as half-century.
         * If score is greater than or equal to 100 but less than 200, it is regarded as a century.
         * If score is greater than or equal to 200, it is regarded as a double-century.
         *
         *
         * NOTE: No scenario of triple-century in this case.
         *
         * Write the code to print the number of half-centuries, centuries and double-centuries scored by the batsman.
         */
        short [] scores = {51, 85, 32, 0, 98, 157, 82, 101, 64, 249};
        int hc=0,c=0,dc=0;
        for(short i: scores){
            if(i>=50&&i<100){
                hc++;
            }else if(i>=100 && i<200){
                c++;
            }else{
                dc++;
            }
        }
        System.out.println("Half century: "+hc+"\nCentury: "+c+"\nDouble century: "+dc);
        /**
         *
         *
         *In mathematics, the Fibonacci series are the numbers in the following integer sequence:
         * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
         * By definition, the first two numbers in the Fibonacci sequence are 0 and 1,
         * and each subsequent number is the sum of the previous two.
         *
         * Write a Java Program to generate above series till n number of times (For example you can try with
         * n = 10 and n = 15) and store it in One-dimensional array.
         * For n = 10, Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
         * For n = 15, Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377
         *
         * Write a for loop to print all the elements of the array.
         */

        System.out.println("Fibonacci series");
        int a=0,b=1;
        int n=sc.nextInt();
        System.out.print(a+", "+b+", ");
        n-=2;
        while(n!=0){
            int temp=b;
            b=a+b;
            a=temp;
            System.out.print(b+"");
            if(n!=1){
                System.out.print(", ");
            }n--;
        }
        /*
        coding challenge 6
         */

        /**
         * Write a java program to create a 2-Dimensional array of 8 * 8 size [to resemble chess board] and
         * initialize all the array elements starting from 1 till 64 (using for loop) as follows:
         * 1 2 3 4 5 6 7 8
         * 9 10 11 12 13 14 15 16
         * 17 18 19 20 21 22 23 24
         * 25 26 27 28 29 30 31 32
         * 33 34 35 36 37 38 39 40
         * 41 42 43 44 45 46 47 48
         * 49 50 51 52 53 54 55 56
         * 57 58 59 60 61 62 63 64
         *
         * Write a nested for loop to print all the elements of 2-Dimensional array in above format.
         */
        int number=1;
        int[][] arr2d = new int[8][8];
        System.out.println("Before asiigning values");
        for(int i=0;i<arr2d.length;i++){
            for (int j=0;j<arr2d.length;j++){
                System.out.print(arr2d[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0;i<arr2d.length;i++){
            for (int j=0;j<arr2d.length;j++){
                arr2d[i][j]=number;
                number++;
            }
        }

        System.out.println("After assigning values");
        for(int i=0;i<arr2d.length;i++){
            for (int j=0;j<arr2d.length;j++){
                System.out.print(arr2d[i][j]+" ");
            }
            System.out.println();
        }

        /**
         * Following code creates an asymmetrical 2-Dimensional int array:
         * int [][] numbers = {
         *   {90, 10, 231},
         *   {-20, 80, 100, 23, 54},
         *   {45, 22},
         *   {87, 98, -100, 49, 73, 35, 19}
         * };
         *
         * Write logic to find out highest number in above array.
         */

        int [][] numbers = {
                  {90, 10, 231},
            {-20, 80, 100, 23, 54},
           {45, 22},
           {87, 98, -100, 49, 73, 35, 19}
         };
        int max=Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            for (int j=0;j<numbers[i].length;j++){
                if(max<numbers[i][j]){
                    max=numbers[i][j];
                }
            }
        }
        System.out.println("The heighest maximum number in the numbers array is "+max);

        /**
         * Following code creates an asymmetrical 2-Dimensional int array:
         * int [][] arr = {
         * {9, 76, 17, 39},
         * {8, 87},
         * {16, 99, 231},
         * {187}
         * };
         * Write logic to store all the array elements of 2-Dimensional array to 1-Dimensional array.
         * You should have following 1-D array:
         * 9
         * 76 17 39 8 87 16 99 231 187
         * Finally write code to print all the elements of above One-Dimensional array.
         */

        int [][] array = {
                 {9, 76, 17, 39},
         {8, 87},
         {16, 99, 231},
         {187}
         };

        //finding the total length for the 1d-array
        int len=0;
        for(int i=0;i<array.length;i++){
            len+=array[i].length;
        }
        int[] array1d = new int[len];
        int k=0;
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++) {
            array1d[k]=array[i][j];
            k++;
            }
        }
        for(int i: array1d){
            System.out.println(i);
        }

    }
}

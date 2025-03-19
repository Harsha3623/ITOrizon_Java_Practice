public class PatternPrinting {
    public static void main(String[] args) {
        /**
         * Print following output using nested for loops:
         * 1
         * 22
         * 333
         * 4444
         * 55555
         * 666666
         * 7777777
         */

        for(int i=1;i<=7;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }

        /**
         * Print following output using nested while loops:
         * 1
         * 22
         * 333
         * 4444
         * 55555
         * 666666
         * 7777777
         */
        int row=1;
        while(row<=7){
            int col=1;
            while(col<=row){
                System.out.print(row);
                col++;
            }
            System.out.println();
            row++;
        }
        /**
         * Print following output using nested for loops.
         * 1    2    3    4    5    6    7    8    9    10
         * 2    4    6    8    10    12    14    16    18    20
         * 3    6    9    12    15    18    21    24    27    30
         * 4    8    12    16    20    24    28    32    36    40
         * 5    10    15    20    25    30    35    40    45    50
         * 6    12    18    24    30    36    42    48    54    60
         * 7    14    21    28    35    42    49    56    63    70
         * 8    16    24    32    40    48    56    64    72    80
         * 9    18    27    36    45    54    63    72    81    90
         * 10    20    30    40    50    60    70    80    90    100
         */

        for(int i=1;i<=10;i++){
            for(int j=1;j<=10;j++){
                System.out.print(i*j+"   ");

            }
            System.out.println();
        }

        /**
         * Print following chess board using nested for loops.
         * W B W B W B W B
         * B W B W B W B W
         * W B W B W B W B
         * B W B W B W B W
         * W B W B W B W B
         * B W B W B W B W
         * W B W B W B W B
         * B W B W B W B W
         */
        char ch='W';
        for(int i=0;i<8;i++){
            char c2=ch;
            for(int j=0;j<8;j++){
                System.out.print(c2+"  ");
                if(c2=='W'){
                    c2-=21;
                }else{
                    c2='W';
                }
            }
            if(ch=='W'){
                ch='B';
            }else {
                ch='W';
            } System.out.println();
        }
    }
}

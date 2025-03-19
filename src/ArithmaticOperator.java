public class ArithmaticOperator {
    public static void main(String[] args) {
        int i1= 10,i2=2;
        float f1=15.5f;
        double d= 20.5;
        int res1= i1+i2;
        float res2 = i1+f1;
        double res3 = i2+d;
        System.out.println(res1+"\n"+res2+"\n"+res3);

        System.out.println(i1/i2+""+"\n"+i1%i2);

        System.out.println("Hello"+i1+i2);


        System.out.println(i1+i2+"hello");

        /**
         * subtraction
         */
        res1= i1-i2;
        res2 = i1-f1;
        res3 = i2-d;

        System.out.println(res1+"\n"+res2+"\n"+res3);

        /**
         * Multiplication
         */
        res1= i1*i2;
        res2 = i1*f1;
        res3 = i2*d;


        System.out.println(res1+"\n"+res2+"\n"+res3);

        /**
         * division
         */

        res1= i1/i2;
        res2 = i1/f1;
        res3 = i2/d;


        System.out.println(res1+"\n"+res2+"\n"+res3);
        /**
         *
         * Pre increment and post increment
         */

        int pre =10;
        int post=1;
        System.out.println("before pre and post incremenet");
        System.out.println(++pre + "   "+ ++post +" pre increment has done");
        System.out.println(pre-- + "   "+ post-- +" post decrement occured");
        System.out.println(pre+" "+post);

    }
}

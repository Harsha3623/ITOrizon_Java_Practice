public class primitiveDT {
    public static void main(String[] args) {
        /*
        byte
        127 to -128
         */
        byte b=127;
        System.out.println(b);

        /*
        short data type
        range --> 32767 to -32768
         */
        short s=32767;
        System.out.println(s);

        /*
        integer data type
        range --> -2147483648 to 2147483647
         */

        int i=2147483647;
        System.out.println(i);
        /*
        long data type
        range Math.pow(2,63)-1 to -1* Math.pow(2,63)
         */
        long l = 2147483648l;
        System.out.println(l);

        /*
        floating data type
        math.pow(2,32);
        for float f is compulsary
         */
        float f = 3.2F;
        double d = 123.0877;
        System.out.println(f+"\n"+d);
    }
}

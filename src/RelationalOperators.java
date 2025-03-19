public class RelationalOperators {
    public static void main(String[] args) {
        int op1=10;
        int op2 = 20;
        /**
         * the relational operators are <,>,<=,>=,==
         */
        System.out.println("op1<op2==> "+(op1<op2));
        System.out.println("op1>op2==> "+(op1>op2));
        System.out.println("op1<=op2==> "+(op1<=op2));
        System.out.println("op1>=op2==> "+(op1>=op2));
        System.out.println("op1==op2==> "+(op1==op2));

        /**
         * logical operator
         * short circuit evaluation
         */

        boolean a= true, b=false;
        System.out.println("a==> "+a+"\nb==> "+b);

        System.out.println("a&&b==> "+(a&&b));
        System.out.println("a||b==> "+(a||b));
        System.out.println("a^b==> "+(a^b));
        System.out.println("a&b==> "+(a&b));
        System.out.println("a|b==> "+(a|b));

        /**
         * Ternary operator
         */
        System.out.println("if 10>20? true: false ==>  "+(10>20?true:false));
        System.out.println("if 10<20? true: false ==>  "+(10<20?true:false));

        /**
         * Assignment operator
         * =,+=,-=,/=,%=
         * example take integer value as 100
         */

        int i=100;

        System.out.println("i value==> "+i);

        System.out.println("i+=10==> "+ (i+=10));
        System.out.println("i-=20==> "+ (i-=20));
        System.out.println("i*=20==> "+ (i*=20));
        System.out.println("i/=20==> "+ (i/=20));
        System.out.println("i%=20==> "+ (i%=20));

        int abc = 7;
        boolean res = abc++ == 7 && ++abc == 9 || abc++ == 9;
        System.out.println("a = " + abc);
        System.out.println("res = " + res);

    }
}

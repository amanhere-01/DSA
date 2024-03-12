package Basics;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumbers {

    public static void main(String[] args) {
//        BI();     // BI = Big Integer
        BD();       // BD = Big Decimal

    }

    static void BI(){
        BigInteger A = BigInteger.valueOf(12345678);    // .valueOf is static and the value inside bracket should be in Integer range
        BigInteger B = BigInteger.valueOf(9876789);     // Converting int to Big integer

        BigInteger C = A.add(B);
//        System.out.println(A+B);    // we can't do this
        System.out.println(C);

        // we can also use BigInteger as constructor and pass the value as String
        BigInteger X = new BigInteger("123456765432345676543456");  // here value can exceed Integer range
        BigInteger Y = new BigInteger("098767890876567898765678976");

        System.out.println(X.add(Y));
        System.out.println(X.multiply(Y));
        System.out.println(Y.divide(X));
        System.out.println(X.remainder(Y));


//        int c = Y.intValue();       // Converting Big Integer to int
//        System.out.println(c);
    }

    static void BD() {
        double x = 0.03;
        double y= 0.04;
        // double ans = y-x;        // this will give some extra number if you run this
        // System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans = Y.subtract(X);
        // System.out.println(ans);

        BigDecimal a = new BigDecimal("456576345675.4546376");
        BigDecimal b = new BigDecimal("547634565352.986785764");

        // operations
        System.out.println(b.add(a));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(b.pow(2));
        System.out.println(b.negate());

        // constants
        BigDecimal con = BigDecimal.ONE;

    }
}

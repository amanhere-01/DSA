package Basics;

import java.math.BigInteger;

public class BigINtegers {

    public static void main(String[] args) {
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


//        int c = Y.intValue();       // Converting Big Integer to int
//        System.out.println(c);

        
    }
}

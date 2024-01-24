package BitwiseOperators;

public class OddEven {
    public static void main(String[] args) {
        int a = 43;
        System.out.println(isOdd(a));
    }
//  if we & a number with 1 it gives the number itself
    static boolean isOdd(int a){
        return (a & 1) == 1;    // here we are doing & of number with 1 and if the LSB is 1 then it is odd.
                                // So 43 in binary is 101011 and if we & with 1 the ans will be 000001 and here we can see the LSB is 1 so it is odd
    }
}

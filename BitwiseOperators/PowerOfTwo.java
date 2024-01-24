package BitwiseOperators;

public class PowerOfTwo {
    public static void main(String[] args) {

        int n= 32;  // NOTE : ) is exception
        boolean ans = (n & ( n -1 )) == 0;
        System.out.println(ans);
    }
}

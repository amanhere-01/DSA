package Recursion.Basic;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(rev(6795));
    }

    static int rev(int n){
        if( n%10 == n){
            return n;
        }
        return (int) ((n%10)*Math.pow(10,helper(n))) + rev(n/10);
    }

    static int helper(int n){
        int digit = (int) (Math.log10(n));  // This will return no of digits -1. Ex- for number 2434 it will return 3
        return digit;
    }
}

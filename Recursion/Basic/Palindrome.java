package Recursion.Basic;

public class Palindrome {
    public static void main(String[] args) {
        int n= 43234;
        System.out.println(isPalindrome(n));
    }
    static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if (x == rev(x)) {
            return true;
        }
        return false;
    }

    static int rev(int n) {
        if (n % 10 == n) {
            return n;
        }
        return (int) ((n % 10) * Math.pow(10, helper(n))) + rev(n / 10);
    }

    static int helper(int n) {
        return (int) (Math.log10(n));
    }
}

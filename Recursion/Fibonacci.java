package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int ans= fib(7);
        System.out.println(ans);
        System.out.println(fibFormula(50));
    }

    static int fibFormula(int n){
        return (int) ( Math.pow( ( (1 + Math.sqrt(5) ) /2 ) , n ) / Math.sqrt(5) );
        // Use long instead of int
    }
    static int fib(int n){
        if(n<2){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
}

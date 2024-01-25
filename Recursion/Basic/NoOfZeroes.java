package Recursion.Basic;

public class NoOfZeroes {
    public static void main(String[] args) {
        int num=10201;
        System.out.println(count(num));
    }

    static int count(int n ){
        return helper(n , 0);
    }

    static int helper(int n , int c){
        if( n==0){
            return c ;
        }

        if( n%10==0){
            return helper(n/10 , c+1);
        }

        return helper( n/10 , c);
    }
}

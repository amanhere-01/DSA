package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println( sum(4271) );
        System.out.println( product(4271) );
        System.out.println( product(401) );
    }

    static int sum(int n){
            if(n == 0){
                return 0;
            }
        return (n%10) + sum(n/10);

    }

    // Product of digits
    static int product(int n){
        if(n%10 == n){      // If n is single digit number. If n=4 then 4%10=4 and it will return 4
            return n;
        }
        return (n%10) * product(n/10);

    }
}

// here we are finding number of digits of any given number in a particular base
// Ex - no of digits in 10 in base 2(binary) is 4 (as in binary 10 is 1010, and it has 4 digits)
// Ex- no of digits in 42423 in base 10(decimal) is 5( as 42423 itself is in decimal, and it has 5 digits)

// We can do this by 2 methods 1st is using right shift operator and increase the counter variable until n>0
// 2nd method is down below

package BitwiseOperators;

public class NoOfDigits {
    public static void main(String[] args) {
        int num= 10;
        int base=2;

        int ans = (int) (Math.log(num) / Math.log(base)) +1;
        System.out.println(ans);
    }
}

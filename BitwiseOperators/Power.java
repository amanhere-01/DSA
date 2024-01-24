// Q) find the power of any number (base)^power  (3)^6 = 729
package BitwiseOperators;

public class Power {
    public static void main(String[] args) {

        int base =3;
        int power = 6;
        int ans = 1;
        while(power>0){
            if( (power & 1) == 1){
                ans *= base;
            }
            base *= base;
            power = power >>1 ;
        }
        System.out.println(ans);
    }
}

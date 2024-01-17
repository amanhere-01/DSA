import java.util.Scanner;

public class NumberOccurence {
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner in= new Scanner(System.in);
        long num= in.nextLong();
        System.out.println("Enter value of number to check occurence");
        int val=in.nextInt();
        int k=0;
        while(num>0){
            long temp= num%10;
            if(temp==val){
                k++;
            }
            num=num/10;
        }
        System.out.println(k);
    }
}

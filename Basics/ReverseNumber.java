package Basics;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner in= new Scanner(System.in);
        int num= in.nextInt();
        int rev=0;
        while(num>0){
            int temp= num%10;
            num/=10;
            rev=rev*10+temp;
        }
        System.out.println(rev);
    }
}

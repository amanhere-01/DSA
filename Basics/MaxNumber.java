package Basics;

public class MaxNumber {
    public static void main(String[] args) {
        int [] a= {21,23,2,212,45,42,54};
        int max= 0;
        for(int element:a){
            if(element>max){
                max=element;
            }
        }
        System.out.println("The value of maximum element in the array is " + max);
    }
}

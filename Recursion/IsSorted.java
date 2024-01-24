package Recursion;

public class IsSorted {
    public static void main(String[] args) {
        int [] nums= {12,23,34,45,56,67};
        System.out.println(sorted(nums , 0));
    }

    static boolean sorted( int [] arr , int index){

        if(index == arr.length-1){
            return true;
        }

        return (arr[index] < arr[index+1]) && sorted(arr, index+1) ;
    }
}

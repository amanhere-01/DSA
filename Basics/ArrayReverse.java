package Basics;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {12,23,34,45,56,76};
        reverse(arr);
        rev(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }


//-----------------Using 2 pointer----------------------------------------
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int start, int end ){
        int temp= arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }

//------------------------Using for loop---------------------------------------------------------------------

    static void rev(int[] arr){
        int end= arr.length;
        for(int i=0; i<end/2 ; i++){
                int temp = arr[i];
                arr[i]= arr[end-i-1];
                arr[end-i-1]=temp;
        }
    }

}

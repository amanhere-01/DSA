package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {-21,43,-4,76,21,-23,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr){
        // take boolean if the array is already sorted then it will execute the outer loop once
        boolean swapped= false;
        for(int i=0; i<arr.length; i++){
            for(int j=1; j< arr.length-i ; j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                    swapped=true;
                }
            }

            if (swapped==false){    // if the array is not swapped it means it is sorted so break the loop
                break;
            }
        }
    }
}

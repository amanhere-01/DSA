package Recursion.Sorting;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {-21,43,-4,76,21,-23,0};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr , int s , int e){
        if(e==0){
            return;
        }
        if( e > s){
            if (arr[s]>arr[s+1]){
                // Swap
                int temp = arr[s];
                arr[s] = arr[s+1];
                arr[s+1] = temp;
            }

            sort(arr , s+1 , e);
        }
        sort(arr, 0, e-1);
    }
}

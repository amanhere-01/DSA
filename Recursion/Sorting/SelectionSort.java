package Recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {-21,43,-4,76,21,-23,0};
//        int[] nums = {4,3,2,1};
        sort(nums, 0, nums.length , 0);
        System.out.println(Arrays.toString(nums));
    }


    private static void sort(int[] arr, int s, int e , int max) {
        if(e==0){
            return;
        }
//      Here we will maintain max index along with recursion. First step will be transversing the array and find max index after then swap
        if(e>s){
            if( arr[s] > arr[max]){
                sort(arr , s+1 , e , s);
            }
            else {
                sort( arr , s+1 , e , max);
            }
        }
//      Now we found the max index, now we swap max index element with last index element
        else {
            int temp = arr[max];
            arr[max] = arr[e-1];
            arr[e-1] = temp;
            sort(arr , 0 , e-1 , 0);
        }
    }
}

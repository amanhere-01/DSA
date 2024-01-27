package Recursion.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] nums = {-21,43,-4,76,21,-23,0};
        sort(nums , 0 , nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr , int low, int high){

        if(low>=high){
            return;
        }

        int s= low;
        int e= high;
        int m = s+(e-s)/2;
        int pivot = arr[m];

        while (s<=e){
            while (arr[s] < pivot){
                s++;
            }
            while (arr[e] > pivot){
                e--;
            }

            if(s<=e){
                //swap
                int temp = arr[s];
                arr[s]= arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // Now that we have put the pivot element in its place, we sort the left and right arrays
        // Above condition violates when end pointer comes at position m-1 and start pointer goes to position m+1
        sort(arr , low , e);
        sort(arr , s , high);


    }
}

// the approach here will be that we find the max element and swap it with the respective last index

package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {-21,43,-4,76,21,-23,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr){
        for(int i=0; i< arr.length; i++){
            int lastIndex= arr.length-i-1;
            // now we find index of max element to be swapped with lastIndex
            int maxIndex = max(arr,lastIndex);
            // now we swap the max element with last index
            swap(arr,maxIndex,lastIndex);
        }
    }

    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }

    static int max(int[] arr, int end) {
        int start=0;
        int max= 0;
        for(int i= start; i<= end; i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }
}

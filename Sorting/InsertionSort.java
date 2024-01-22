package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {-21,43,-4,76,21,-23,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr){
        for(int i=0; i< arr.length-1 ; i++){    // here i will rotate till N-2 , N=arr.length
            for (int  j= i+1 ; j>0 ; j--){
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }
}

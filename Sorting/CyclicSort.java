//  whenever there is array of 1 to N number then think of cyclic sort
// we use cyclic sort for finding missing number or finding smallest positive missing number

package Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr){
        int i=0;
        while(i< arr.length){
            while(arr[i]!=i+1){
                swap(arr,i,arr[i]-1);
            }
            i++;
        }
    }
    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }
}

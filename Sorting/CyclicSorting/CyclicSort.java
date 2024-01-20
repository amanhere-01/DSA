//  whenever there is array of 1 to N number then think of cyclic sort
// we use cyclic sort for finding missing number or finding smallest positive missing number
// If range is [0,N] then every element will be at index= value
//  If range is [1,N] then every element will be at index = value -1
package Sorting.CyclicSorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {2,4,1,5,3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr){
        int i=0;
        while(i< arr.length){
            int correct=  arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }
}

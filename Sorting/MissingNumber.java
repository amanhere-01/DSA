// Q) https://leetcode.com/problems/missing-number/
// in ques it is mentioned array [0,n] so we will be using quick sort

package Sorting;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int [] nums={4,2,0,1};
        int [] num2= {2,1,3,0};

        System.out.println( missing(nums));
        System.out.println( missing(num2));
    }

    static int missing(int [] nums){
        int i=0;
        // first we sort the element
        while (i<nums.length){
            if(nums[i]< nums.length && nums[i] != i){
                swap(nums,i,nums[i]);
            }
            else {
                i++;
            }
        }

        // now after sorting two cases arise- 1st case [0,1,2,4] - here for index=3 ,3 is not there so missing element is 3
        // 2nd case [0,1,2,3] = here all the index is equal to element but missing element is 4 so we return arr.length

        for(int index=0; index<nums.length; index++){       // case 1
            if(nums[index]!=index){
                return index;
            }
        }

        // case 2
        return nums.length;
    }

    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }
}

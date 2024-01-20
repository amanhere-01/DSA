// Q) https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// same as https://leetcode.com/problems/missing-number/

package Sorting.CyclicSorting;


import java.util.ArrayList;
import java.util.List;

public class MultipleMissingNo {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(missing(nums));
    }

    static List<Integer> missing(int [] nums){
        int i=0;
        // first we sort the element
        while (i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                swap(nums,i,nums[i]-1);
            }
            else {
                i++;
            }
        }




        ArrayList<Integer> list = new ArrayList<>();
        for(int index=0; index<nums.length; index++){
            if(nums[index]!=index+1){
                list.add(index+1);
            }
        }

        return list;
    }

    static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }
}

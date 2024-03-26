//  https://leetcode.com/problems/first-missing-positive/description/?envType=daily-question&envId=2024-03-26

package Sorting.CyclicSorting;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[correct] != nums[i]){      // ignore negative numbers and number which are greater than size of array
                swap(nums,correct, i);
            }
            else{
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j]!= j+1){
                return j+1;
            }
        }

        return nums.length+1;
    }

    static void swap(int[] nums, int first, int second){
        int temp= nums[first];
        nums[first]= nums[second];
        nums[second]= temp;
    }
}

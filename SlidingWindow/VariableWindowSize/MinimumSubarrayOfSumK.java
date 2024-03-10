//  https://leetcode.com/problems/minimum-size-subarray-sum/description/
//   return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

package SlidingWindow.VariableWindowSize;

public class MinimumSubarrayOfSumK {

    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
//        int target = 7;
        int[] nums = {1,2,3,4,5};
        int target = 11;
        
        System.out.println(minSubArrayLen(target , nums));
    }


    static int minSubArrayLen(int target, int[] nums) {

        int sum=0;
        int  i=0;
        int length= Integer.MAX_VALUE;

        for(int j=0; j<nums.length; j++){
            sum += nums[j];

            if(sum == target){
                length= Math.min(length, j-i+1);
            }

            else if (sum > target){
                length= Math.min(length, j-i+1);
                while(sum > target){
                    sum -= nums[i];
                    i++;
                    if(sum >= target){
                        length= Math.min(length, j-i+1);
                    }
                }
            }
        }

        if(length == Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
}

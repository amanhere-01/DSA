//  https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29

package SlidingWindow.VariableWindowSize;

public class MaxElementSubarrayCount {

    public long countSubarrays(int[] nums, int k) {
        int max=0;
        for(int num: nums){
            if(num>max){
                max=num;
            }
        }

        long result=0;
        int countMax=0;
        int n= nums.length;
        int i=0,j=0;
        while(j<n){
            if(nums[j]==max){
                countMax++;
            }

            while(countMax>=k){
                result += n-j;
                if(nums[i]==max){
                    countMax--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
}

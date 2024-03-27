//  https://leetcode.com/problems/subarray-product-less-than-k/?envType=daily-question&envId=2024-03-27

package SlidingWindow.VariableWindowSize;

public class SubarrayProductLessThanK {
    static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }

        int i=0, j=0;
        int prod= 1;
        int count=0;
        while(j<nums.length){
            prod *= nums[j];

            while(prod >= k){
                prod /= nums[i];
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}

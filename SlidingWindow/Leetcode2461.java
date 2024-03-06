//  Maximum Sum of Distinct Subarrays With Length K
//  https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

package SlidingWindow;

import java.util.HashMap;

public class Leetcode2461 {

    public static void main(String[] args) throws Exception {
        int[] arr= {1,5,4,2,9,9,9};
        System.out.println(maximumSubarraySum(arr,3));
    }

    static long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long maxSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
            sum += nums[i];
        }

        if (map.size() == k) {
            maxSum = sum;
        }

        int i=0;
        for(int j=k; j<nums.length; j++){
            if (map.containsKey(nums[j])) {
                map.put(nums[j], map.get(nums[j]) +1);
            }
            else {
                map.put(nums[j], 1);
            }


            if (map.get(nums[i]) == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }

            sum= sum - nums[i] + nums[j];
            i++;
            if (map.size() == k) {
                maxSum = Math.max(maxSum,sum);
            }
        }

        return maxSum;
    }
}

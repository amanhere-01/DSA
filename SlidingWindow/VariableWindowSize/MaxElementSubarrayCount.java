//  https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29

package SlidingWindow.VariableWindowSize;

import java.util.ArrayList;

public class MaxElementSubarrayCount {

    //  TC=O(n) and SC=O(1)
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

    // 2nd approach
    //TC=O(n) and SC=O(n) (took array to store index)
    public long countSubarrays2(int[] nums, int k) {
        int max=0;
        for(int num: nums){
            if(num>max){
                max=num;
            }
        }

        long result=0;
        int n= nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i]==max){
                arr.add(i);
            }
            int size= arr.size();
            if(size>=k){
                int last_Index = size-k;
                result += arr.get(last_Index) +1;
            }

        }
        return result;
    }
}

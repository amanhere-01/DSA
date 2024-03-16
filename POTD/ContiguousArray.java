//  https://leetcode.com/problems/contiguous-array/description/?envType=daily-question&envId=2024-03-16
//  Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

package POTD;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 0, 1, 0, 1};
        System.out.println(findMaxLength(nums));
    }

    static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key=sum && value=index
        map.put(0,-1);              
        int maxLen = 0;
        int sum=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                sum -= 1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                int index = map.get(sum);
                maxLen = Math.max(maxLen, i - index);
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}

//  https://leetcode.com/problems/longest-consecutive-sequence/description/

package SetsAndMaps.Question;

import java.util.HashSet;

public class ConsecutiveSequence {
 
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }

        int maxLen=0;
        for(int num: set){
            if(!set.contains(num-1)){   // If previous number does not exist then it is the starting point
                int length=1;
                while(set.contains(num+1)){
                    num++;
                    length++;
                }
                maxLen= Math.max(maxLen, length);
            }
        }
        return maxLen;
    }
}

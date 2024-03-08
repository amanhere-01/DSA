//  https://leetcode.com/problems/longest-substring-without-repeating-characters/
//  Find the length of the longest substring without repeating characters.

package SlidingWindow.VariableWindowSize;

import java.util.HashMap;

public class SubstringWithDiffChars {
    public static void main(String[] args) {
//        String s = "pwwkew";
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    static int lengthOfLongestSubstring(String s) {
        HashMap<Character , Integer> map= new HashMap<>();

        int i=0, j=0;
        int maxLen=0;

        while (j<s.length()){
            char ch = s.charAt(j);

            if(!map.containsKey(ch)){
                map.put(ch, j);
                maxLen = Math.max(maxLen , j-i+1);
            }
            else{
                i = map.get(ch) + 1;
                map.put(ch, j);
            }
            j++;
        }
        return maxLen;
    }
}

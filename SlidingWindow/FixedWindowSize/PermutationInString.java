//  https://leetcode.com/problems/permutation-in-string/description/
//   return true if one of s1's permutations is the substring of s2.

package SlidingWindow.FixedWindowSize;

import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {
        String  s1 = "ab", s2 = "eidboaoo" ;
        System.out.println(checkInclusion(s1,s2));
    }

    // Not optimised
    static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map= new HashMap<>();

        for (char ch : s1.toCharArray()){
            map.put(ch , map.getOrDefault(ch, 0) +1);
        }

        int k = s1.length();        // Window size
        int count = map.size();
        int i=0;

        for (int j=0; j<s2.length(); j++){
            char ch = s2.charAt(j);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) -1);
                if(map.get(ch) == 0){
                    count--;
                }
            }

            if(j-i+1 == k){
                if (count == 0){
                    return true;
                }

                // Now sliding window
                char removed = s2.charAt(i);
                if(map.containsKey(removed)){
                    if (map.get(removed) == 0){
                        count++;
                    }
                    map.put(removed, map.get(removed) +1);
                }
                i++;
            }
        }
        return false;
    }
}

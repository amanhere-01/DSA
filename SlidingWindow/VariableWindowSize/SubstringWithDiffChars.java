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
        // We will do it with same method as LongestKUniqueChars
        // Here k is not given. We will treat k as window size
        // We will keep checking the size of map with current window size
        // Take k= j-i+1. If map.size()== j-i+1 then this is ans
        // If map.size() < j-i+1 then it means char is repeating so we will pop until size==j-i+1
        HashMap<Character , Integer> map = new HashMap<>();
        int i=0,j=0;
        int max=0;

        while (j< s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) +1);
            }else{
                map.put(ch, 1);
            }

            // here k is variable and it is the size of current window
            if(map.size() == j-i+1){
                max = Math.max(max , j-i+1);

            }

            if(map.size() < j-i+1){         // If size is less than current window size then it means the char is repeating at index j
                while (map.size() < j-i+1){          // remove the item until map.size()==k
                    char remove = s.charAt(i);
                    if( map.get(remove) >1 ){
                        map.put(remove , map.get(remove) -1);
                    }else {
                        map.remove(remove);
                    }
                    i++;
                }
            }
            j++;
        }

        return max;
    }


    // My approach

//    static int lengthOfLongestSubstring(String s) {
//        HashMap<Character , Integer> map= new HashMap<>();
            // key= char, value= index
//        int i=0, j=0;
//        int maxLen=0;
//
//        while (j<s.length()){
//            char ch = s.charAt(j);
//
//            if(!map.containsKey(ch)){
//                map.put(ch, j);
//                maxLen = Math.max(maxLen , j-i+1);
//            }
//            else{
//                int NewI= map.get(ch) +1;
//                while (i != NewI){
//                    char remove = s.charAt(i);
//                    map.remove(remove);
//                    i++;
//                }
//                map.put(ch, j);
//            }
//            j++;
//        }
//        return maxLen;
//    }
}

//  https://leetcode.com/problems/minimum-window-substring/description/
//  return the minimum window substring of s such that every character in t (including duplicates) is included in the window.

package SlidingWindow.VariableWindowSize;

import java.util.HashMap;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t= "ABC";
//        String s = "timetopractice";
//        String t= "toc";
        System.out.println(minWindow(s,t));
    }

    static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch= t.charAt(i);
            map.put(ch , map.getOrDefault(ch,0) +1);

        }

        int i=0, j=0;
        int count= map.size();
        int minLength = Integer.MAX_VALUE;
        int startIndex=0;
        while (j< s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){         // if freq of ch is 0 then we have to decrease count
                    count--;
                }
            }

            while (count == 0){
                if (j-i+1 <= minLength){
                    minLength= j-i+1;
                    startIndex=i;
                }
                char remove = s.charAt(i);
                if (map.containsKey(remove)){
                    if (map.get(remove) == 0){
                        count++;
                    }
                    map.put(remove , map.get(remove) +1);
                }
                i++;
            }
            j++;
        }
        return s.substring(startIndex, startIndex+minLength) ;
    }
}

/*
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }

            Instead of using this use getOrDefault
            map.put(ch , map.getOrDefault(ch,0) +1);
 */
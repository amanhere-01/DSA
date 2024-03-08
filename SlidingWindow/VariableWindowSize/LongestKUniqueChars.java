//  https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
//   Find the longest substring with K distinct characters.
package SlidingWindow.VariableWindowSize;

import java.util.HashMap;

public class LongestKUniqueChars {
    public static void main(String[] args) {
//        String s=  "aabacbebebe";
        String s=  "aaa";
        System.out.println(longestkSubstr(s, 3));
    }

    static int longestkSubstr(String s, int k) {
        HashMap<Character , Integer> map = new HashMap<>();
        int i=0,j=0;
        int max=-1;

        while (j< s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) +1);
            }else{
                map.put(ch, 1);
            }

            if(map.size() < k){
                j++;
            }

            if(map.size() == k){
                max = Math.max(max , j-i+1);    // j-i+1 is the window size you can say
                j++;
            }

            if(map.size() >k){
                while (map.size() >k){          // remove the item until map.size()==k
                    char remove = s.charAt(i);
                    if( map.get(remove) >1 ){
                        map.put(remove , map.get(remove) -1);
                    }else {
                        map.remove(remove);
                    }
                    i++;
                }
                j++;
            }
        }

        return max;
    }
}

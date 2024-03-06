//  https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class TotalNoOfAnagrams {
    public static void main(String[] args) {
        String txt ="rofxxorfxdofr";
        String pat = "for";
        System.out.println(search(pat, txt));
    }


    static int search(String pat, String txt) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i< pat.length(); i++){
            char ch = pat.charAt(i);
            if(map2.containsKey(ch)){
                map2.put(ch, map2.get(ch) +1);
            }else{
                map2.put(ch,1);
            }
        }

        int i=0, j=0;
        int k = pat.length();
        int count=0;
        while(j<txt.length()){
            char ch = txt.charAt(j);
            //  Adding the favourable elements
            if (map2.containsKey(ch)){
                if(map1.containsKey(ch)){
                    map1.put(ch, map1.get(ch) +1);
                }else{
                    map1.put(ch,1);
                }
            }
            // Making gap of window size(k)
            if(k > j-i+1){
                j++;
            }
            // Now that gap is maintained
            else if( k == j-i+1){
                // Defining results
                if(map1.equals(map2)){
                    count++;
                }

                // Sliding window
                char remove= txt.charAt(i);
                if(map1.containsKey(remove)){
                    if ((map1.get(remove)) >1){
                        map1.put(remove , map1.get(txt.charAt(i)) -1);
                    }else{
                        map1.remove(remove);
                    }
                }
                i++;
                j++;
            }
        }
        return count;
    }
}

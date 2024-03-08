//  https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
// question is same as TotalNoOfAnagrams in this folder

package SlidingWindow.FixedWindowSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        // adding all the chars of p into map
        for(int i=0; i<p.length(); i++){
            char ch= p.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }

        int i=0, j=0;
        int count= map.size();
        int k= p.length();          // Window size

        while(j<s.length()){
            char ch= s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){         // if freq of ch is 0 then we have to decrease count
                    count--;
                }
            }

            // Creating gap of window size k
            if(k > j-i+1){
                j++;
            }

            else if(k == j-i+1){
                if(count==0){
                    list.add(i);
                }

                // Sliding the window
                char remove= s.charAt(i);
                if(map.containsKey(remove)){
                    if(map.get(remove)==0){     // While moving ahead if frequency of remove is 0 then we have to increase count then we put the removing char into map again
                        count++;
                    }
                    map.put(remove, map.get(remove)+1);
                }
                i++;
                j++;
            }
        }
        return list;
    }
}

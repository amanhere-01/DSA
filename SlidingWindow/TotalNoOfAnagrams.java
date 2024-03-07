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
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i< pat.length(); i++){
            char ch = pat.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) +1);
            }else{
                map.put(ch,1);
            }
        }

        int i=0, j=0;
        int k = pat.length();
        int count=map.size();
        int ans=0;
        while(j<txt.length()){
            char ch = txt.charAt(j);
            //  Adding the favourable elements
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            // Making gap of window size(k)
            if(k > j-i+1){
                j++;
            }

            // Now that gap is maintained
            else if( k == j-i+1){
                // Defining results
                if(count==0){
                    ans++;
                }

                // Slide window
                char remove= txt.charAt(i);
                if(map.containsKey(remove)){
                    if(map.get(remove)==0){
                        count++;
                    }
                    map.put(remove, map.get(remove) + 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }


    // Here maintain 2 maps. First we will put all the chars of pat into map2(chars,frequency)  then we traverse in txt.
    // If the char in txt is present in map2 then add that char in map1 and when the window size is reached compare both maps.
    // If both maps are equal then it is anagram
    static int search2(String pat, String txt) {
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

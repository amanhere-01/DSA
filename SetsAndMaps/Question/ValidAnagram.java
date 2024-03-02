package SetsAndMaps.Question;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    // using 2 hash maps
    static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> hm= new HashMap<>();
        char[] s1= s.toCharArray();
        for(char ch: s1){
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) + 1);
            }
            else{
                hm.put(ch, 1);
            }
        }
        char[] t2= t.toCharArray();
        for(char ch: t2){
            if(!hm.containsKey(ch) || hm.get(ch)<=0){
                return false;
            }
            hm.put(ch, hm.get(ch)-1);
        }
        return true;
    }

    // Using 1 hashMap
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> hm= new HashMap<>();
        char[] s1= s.toCharArray();
        for(char ch: s1){
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) + 1);
            }
            else{
                hm.put(ch, 1);
            }
        }
        char[] t2= t.toCharArray();

        for(char ch: t2){
            if(!hm.containsKey(ch) || hm.get(ch)<=0){   // here checking along with traversal in t2
                return false;
            }
            hm.put(ch, hm.get(ch)-1);
        }
        return true;
    }

    // 3rd approach
    public boolean isAnagram3(String s, String t) {
        char[] arr1= s.toCharArray();
        char[] arr2= t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }

    public boolean isAnagram4(String s, String t) {

    }

}

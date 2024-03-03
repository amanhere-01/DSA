//  https://leetcode.com/problems/isomorphic-strings/description/

package SetsAndMaps.Question;

import java.util.LinkedHashMap;

public class IsomorphicString {

    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s,t));
    }

//    static boolean isIsomorphic(String s, String t) {
//        LinkedHashMap<Character, Character> map = new LinkedHashMap<>();
//
//        for(int i=0; i<s.length(); i++){
//            if (map.containsKey(s.charAt(i))) {
//                if(map.get(s.charAt(i)) != t.charAt(i)){
//                    return false;
//                }
//            }
//            else if (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))){
//                return false;
//            }
//            else {
//                map.put(s.charAt(i), t.charAt(i));
//            }
//        }
//
//        return true;
//    }

    // This is almost same as above but TC of above is 11ms and TC of this is 10ms
    static boolean isIsomorphic(String s, String t) {
        LinkedHashMap<Character, Character> map = new LinkedHashMap<>();

        for(int i=0; i<s.length(); i++){
            char sch= s.charAt(i);
            char tch= t.charAt(i);
            if (map.containsKey(sch)) {
                if(map.get(sch) != tch){
                    return false;
                }
            }
            else if (map.containsValue(tch)){
                return false;
            }
            else {
                map.put(sch, tch);
            }
        }

        return true;
    }
}

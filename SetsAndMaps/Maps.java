package SetsAndMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(19,"wigga");
        hm.put(28,"sigga");
        hm.put(37,"nigga");
        System.out.println(hm);
        System.out.println(hm.entrySet());      // This will also print whole map
        System.out.println(hm.get(2));
        System.out.println(hm.containsKey(3));
        System.out.println(hm.containsValue("broski"));
        hm.put(3,"broski");     // This will override the value which has key=3
        hm.putIfAbsent(3,"nigesh");     // This will override only when key=3 is not present
        System.out.println(hm);
        System.out.println(hm.keySet());    // Print all the keys
        System.out.println(hm.values());    // Print all the values

        // Iterating over keys
        for(int i: hm.keySet()){
            System.out.println(i);
        }
        // Iterating over values
        for(String s: hm.values()){
            System.out.println(s);
        }
        // Or we can use var without specifying data type
        for(var element: hm.keySet()){
            System.out.println(element);
        }
        // Iterate over key, value mapping
        for(var e: hm.entrySet()){
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }


        // LinkedHashMap
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(89,"nigga");
        lhm.put(19,"wigga");
        lhm.put(37,"nigga");
        lhm.put(28,"sigga");
        System.out.println(lhm);


        // TreeMap
        TreeMap<Integer, String> thm = new TreeMap<>();
        thm.put(19,"wigga");
        thm.put(89,"nigga");
        thm.put(37,"nigga");
        thm.put(28,"sigga");
        System.out.println(thm);



    }
}

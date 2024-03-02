package SetsAndMaps;

import java.util.HashMap;

public class MaxFrequency {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 5, 5, 5, 3};
        System.out.println(maxFreq(nums));
    }

    static int maxFreq(int [] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        int val = 0;
        int ansKey = -1;

        // Here traversing the whole Map
//        for (var ele : freqMap.entrySet()) {
//            if (ele.getValue() > val) {
//                val = ele.getValue();
//                ansKey = ele.getKey();
//            }
//        }

        // Or we could traverse only Key Set
        for(var key: freqMap.keySet()){
            if(freqMap.get(key) > val){
                val= freqMap.get(key);
                ansKey= key;
            }
        }
        return ansKey;
    }
}

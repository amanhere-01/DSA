//  https://leetcode.com/problems/top-k-frequent-elements/

package HeapDs.Questions;


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
    static class Pair implements Comparable<Pair>{
        int freq;
        int value;
        Pair(int f, int v){
            this.freq=f;
            this.value=v;
        }

        public int compareTo(Pair o){
            //  (Integer.compare(o.freq, this.freq)), which means you're prioritizing pairs with higher frequencies.
            //  Since we want min heap(prioritize the pair with low frequency at the top) we'll do it other way
            return Integer.compare(this.freq, o.freq);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();


        for (int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(var e: map.keySet()){
            pq.offer(new Pair(map.get(e), e));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] arr = new int[k];
        int index=0;
        while (!pq.isEmpty()){
            arr[index++] = pq.poll().value;
        }
        return arr;
    }
}

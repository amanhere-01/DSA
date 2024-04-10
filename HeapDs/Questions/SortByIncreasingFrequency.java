//  https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

package HeapDs.Questions;


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortByIncreasingFrequency {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] nums2 = {-1,1,-6,4,5,-6,1,4,1};
//        System.out.println(Arrays.toString(frequencySort(nums)));
        System.out.println(Arrays.toString(frequencySort(nums2)));
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
            if(this.freq==o.freq){
                return Integer.compare(o.value,this.value);     //  This means if frequencies are equal, you prioritize pairs with lower values.
            }
            return Integer.compare(this.freq, o.freq);  // here  prioritizing the pair with the lower frequency.
        }
    }

    public static int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();


        for (int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(var e: map.keySet()){
            pq.offer(new Pair(map.get(e), e));
        }

        int index=0;
        while(!pq.isEmpty()){
            int fre = pq.peek().freq;
            while(fre-- >0){
                nums[index++]= pq.peek().value;
            }
            pq.poll();
        }

        return nums;
    }
}

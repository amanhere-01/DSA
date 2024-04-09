//https://leetcode.com/problems/find-k-closest-elements/

package HeapDs.Questions;

import java.util.*;

public class kClosestElement {


    static class Pair implements Comparable<Pair>{
        int val;
        int gap;

        Pair(int v, int g){
            this.val=v;
            this.gap=g;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.gap == o.gap){
                return this.val - o.val;    // if gap is equal then return the value which is smaller
            }else{
                return this.gap - o.gap;        // else return the gap which is smaller
            }
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();

        for (int num: arr ){
            if(pq.size()<k){
                pq.offer(new Pair(num, Math.abs(num - x)));

            }

            else{
                if (pq.peek().gap > Math.abs(num - x)){
                    pq.poll();
                    pq.offer(new Pair(num,Math.abs(num - x) ));
                }
            }
        }

        while (!pq.isEmpty()){
            list.add( 0,pq.poll().val);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] arr = {5,6,7,8,9};
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        System.out.println(findClosestElements(arr,3,5));
    }
}

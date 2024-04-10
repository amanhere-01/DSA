//  https://leetcode.com/problems/k-closest-points-to-origin/

package HeapDs.Questions;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    static class Pair implements Comparable<Pair> {
        double distance;
        int[] point;
        Pair(double distance, int[] point){
            this.distance= distance;
            this.point= point;
        }

        public int compareTo(@NotNull Pair o) {
            return Double.compare(o.distance, this.distance);   // Condition for maxHeap
        }
    }

    public static  int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int[] arr: points){
            pq.offer(new Pair(Math.pow(arr[0],2 )+ Math.pow(arr[1],2) ,arr));    // we could just do x^2 + y^2 too instead of taking sqrt

            if (pq.size()>k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][];
        int index=0;
        while (!pq.isEmpty()){
            ans[index++]= pq.poll().point;
        }
        return ans;
    }
}

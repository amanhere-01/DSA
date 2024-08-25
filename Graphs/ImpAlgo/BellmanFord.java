// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
// TC = ExV
package Graphs.ImpAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    class Solution {
        static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
            int[] dist = new int[V];
            Arrays.fill(dist, (int)(1e8));
            dist[S] = 0;
            for(int i=0; i<V-1; i++){
                for(ArrayList<Integer>  neigh: edges){
                    int u = neigh.get(0);
                    int v = neigh.get(1);
                    int wt = neigh.get(2);
                    if(dist[u]!=1e8 && dist[u] + wt < dist[v]){
                        dist[v]=dist[u] + wt;
                    }
                }
            }
            // Detecting any negative cycle by doing again relaxation
            for(ArrayList<Integer>  neigh: edges){
                    int u = neigh.get(0);
                    int v = neigh.get(1);
                    int wt = neigh.get(2);
                    if(dist[u]!=1e8 && dist[u] + wt < dist[v]){
                        return new int[] {-1};
                    }
                }
            return dist;
        }
    }
}

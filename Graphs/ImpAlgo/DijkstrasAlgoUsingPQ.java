// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix
// TC = ElogV
package Graphs.ImpAlgo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgoUsingPQ {
    static class Pair implements Comparable<Pair> {
        int dist;
        int node;
        Pair(int d, int n){
            this.dist = d;
            this.node = n;
        } 
        
        @Override
        public int compareTo(Pair other) {
            // Compare based on distance (for min-heap)
            return this.dist - other.dist;
        }
    }
    class Solution
    {
        
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            
            int[] dist = new int [V];
            for(int i=0;i<V;i++){
                dist[i] = (int) (1e9);
            }
            dist[S] = 0;
            pq.add(new Pair(0,S));
            
            while(!pq.isEmpty()){
                Pair p = pq.remove();
                
                for(int i=0; i<adj.get(p.node).size(); i++){
                    
                    int neigh = adj.get(p.node).get(i).get(0);
                    int wt = adj.get(p.node).get(i).get(1);
                    if (p.dist + wt < dist[neigh]) {
                        dist[neigh] = p.dist + wt;
                        pq.add(new Pair(dist[neigh], neigh));
                    }
                }
            }
            
            return dist;
            
        }
    }
}

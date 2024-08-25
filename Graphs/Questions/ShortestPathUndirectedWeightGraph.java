// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph

package Graphs.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathUndirectedWeightGraph {
    class Pair implements Comparable<Pair> {
        int dist;
        int node;
        ArrayList<Integer> list;
        Pair(int d, int n ){
            this.node = n;
            this.dist = d;
        } 
        
        @Override
        public int compareTo(Pair other) {
            // Compare based on distance (for min-heap)
            return this.dist - other.dist;
        }
} 

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int [n+1];
        int[] parent = new int[n+1];
        
        for(int i=1;i<=n;i++){
            dist[i] = (int) (1e9);
            parent[i] = i; 
        }
        dist[1] = 0;
        pq.add(new Pair(0,1));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            
            for(int i=0; i<adj.get(p.node).size(); i++){
                int neigh = adj.get(p.node).get(i).node;
                int wt = adj.get(p.node).get(i).dist;
                
                if(p.dist + wt < dist[neigh]){
                    dist[neigh] = p.dist + wt;
                    pq.add(new Pair(dist[neigh], neigh));
                    parent[neigh] = p.node;
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        if(dist[n]==1e9){
            list.add(-1);
            return list;
        }
        
        int node = n;
        while(node!=1){
            list.add(node);
            node = parent[node];
        }
        list.add(1);
        list.add(dist[n]);
        
        Collections.reverse(list);     
    
        return list;
        
    }
}
}

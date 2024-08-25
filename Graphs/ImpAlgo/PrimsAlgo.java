package Graphs.ImpAlgo;
//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair{
        int wt,node;
        Pair(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.wt-y.wt);
        boolean[] vis = new boolean[V];
        int sum = 0;
        
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            
            if(vis[temp.node]) continue;
            
            vis[temp.node] = true;
            sum += temp.wt;
            
            for(int i=0; i<adj.get(temp.node).size(); i++ ){
                int neigh = adj.get(temp.node).get(i)[0];
                int neighWt = adj.get(temp.node).get(i)[1];
                if(!vis[neigh]){
                    pq.offer(new Pair(neighWt,neigh));
                }
            }
        }
        
        return sum;
    }
}
}

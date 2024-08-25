//  https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph

package Graphs.Questions;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDAG {
    // Using topology sorting 
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }

    class Solution {

        public int[] shortestPath(int N,int M, int[][] edges) {

            // Step 1: Create adjacency list
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i=0; i<N; i++){
                adj.add(new ArrayList<Pair>());
            }
            
            for(int i=0; i<M; i++){
                adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            }
            
            // Step 2: Perform topological sort using DFS
            boolean[] vis = new boolean[N];
            Stack<Integer> st = new Stack<>();
            for(int i=0; i<N; i++){
                if(!vis[i]){
                    topoDfs(i,vis,st,adj);
                }
            }
            
            // Step 3: Initialize distance array and mark the distances
            int dist[] = new int[N];
            for (int i = 0; i < N; i++) {
                dist[i] = (int)1e9;
            }

            dist[0] = 0;
            while (!st.isEmpty()) {
                int node = st.pop();
                
                for(Pair p : adj.get(node)){
                    int weightSum = dist[node] + p.weight;
                    dist[p.node] = Math.min(dist[p.node], weightSum);
                }
            }
            
            // make unreachable nodes distance -1
            for (int i = 0; i < N; i++) {
                if (dist[i] == 1e9){
                    dist[i] = -1;
                } 
            }
            return dist;
        }
 	
        void topoDfs(int node, boolean vis[], Stack<Integer> st, ArrayList<ArrayList<Pair>> adj){
            vis[node] = true;
            
            for(Pair p : adj.get(node)){
                if(!vis[p.node]){
                    topoDfs(p.node,vis,st,adj);
                }
            }
            
            st.push(node);
        }
 	
    }
}

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphCycle {
    // USING TOPOSORT(BFS)(Kahn's Algo)  
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }       
        //push 0 indegree node to queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }       
        // main logic
        int count =0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
        
            
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        
        return count==V ? false : true;
    }
    

    // 2nd method 
    // USING PATH VISITED ARRAY
    
    public boolean isCyclic2(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++ ){
            if(!vis[i]){
                if(dfs(i,new boolean[V],vis,adj))    return true;
            }
        }
        return false;
    }
    
    boolean dfs(int node, boolean[] pathVisited, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVisited[node] = true;
        
        for(int neighbour : adj.get(node)){
            if(!vis[neighbour]){
                if(dfs(neighbour,pathVisited,vis,adj)) return true;
            }
            else if(pathVisited[neighbour]){
                return true;
            } 
        }
        pathVisited[node] = false;
        return false;
    }
}

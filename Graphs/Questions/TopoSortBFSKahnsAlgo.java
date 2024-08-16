//https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort


// When we are asked something before something then think of topology
package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFSKahnsAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       
        // consturct indegree array 
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
        int[] ans = new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
        
            
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        
        return ans;
    }
}

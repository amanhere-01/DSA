//https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort


// When we are asked something before something then think of topology
package Graphs.Questions;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean [] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }
        
        int[] ans = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        
        return ans;
    }
    
    static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh,vis,st,adj);
            }
        }
        st.push(node);
    }
}

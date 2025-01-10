package Graphs.ImpAlgo;

import java.util.ArrayList;
import java.util.Stack;

// This concept is used in finding Strongly Connected Component

public class KosarajusAlgo {

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];

        // add elements to the stack in finishing time order
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }

        // reverse the given graph
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjReverse.add(new ArrayList<>());
        }
        for (int i=0; i<V; i++){
            vis[i] = false;         // making all the nodes again unvisit for further dfs call
            for(int node : adj.get(i)){
                adjReverse.get(node).add(i);
            }
        }

        // do the dfs in reversed graph
        int scc = 0;            // SCC = Strongly Connected Component
        while (!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                scc++;
                dfs2(node,vis,adjReverse);
            }
        }
        return scc;
    }

    private void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjReverse) {
        vis[node] = true;
        for (int neigh : adjReverse.get(node)){
            if(!vis[neigh]){
                dfs2(neigh,vis,adjReverse);
            }
        }
    }

    private void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int neigh : adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh,vis,st,adj);
            }
        }
        st.push(node);
    }



}

package Graphs;

import java.util.ArrayList;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0,adj,visited,list);
        return list;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited ,ArrayList<Integer> list){
        list.add(node);
        visited[node]= true;

        for (int neighbour: adj.get(node)){
            if (!visited[neighbour]){
                dfs(neighbour,adj,visited,list);
            }
        }
    }
}

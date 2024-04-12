//  https://leetcode.com/problems/number-of-provinces/description/

package Graphs.Questions;

import java.util.ArrayList;

public class NoOfProvince {


    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V+1];
        int count=0;

        for (int i=0;  i<V;i++){
            if (!visited[i]){
                count++;
                dfsMatrix(i, isConnected,visited);
            }
        }
        return count;
    }

    private void dfsMatrix(int node,int[][] mat , boolean[] visited) {
        visited[node]= true;

        for (int j=0; j< mat.length; j++){
            if (!visited[j] && mat[node][j] ==1){
                dfsMatrix(j,mat,visited);
            }
        }
    }

    // Here converting matrix to list
    public int findCircleNum2(int[][] isConnected) {
        int V = isConnected.length;
        // converting adj matrix into adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int j=0; j< V; j++){
                if (isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[V+1];
        int count=0;
        for (int i=0;  i<V;i++){
            if (!visited[i]){
                count++;
                dfs(i, adj,visited);
            }
        }
        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node]= true;

        for (int neighbour: adj.get(node)){
            if (!visited[neighbour]){
                dfs(neighbour,adj,visited);
            }
        }
    }
}

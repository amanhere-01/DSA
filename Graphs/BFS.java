
//  https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
package Graphs;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1,2,3)));   // or i could do it as--- adj.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(4)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        System.out.println(bfsOfGraph(5,adj));  
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        q.offer(0);
        visited[0]= true;

        while(!q.isEmpty()){
            int node= q.poll();
            bfs.add(node);

            // Add to the queue which are not visited
            for (int n: adj.get(node)){
                if(!visited[n]){
                    q.offer(n);
                    visited[n] = true;
                }
            }
        }
        return bfs;
    }
}

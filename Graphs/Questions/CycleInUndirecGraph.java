//  https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

package Graphs.Questions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirecGraph {

    class Pair{
        int child;
        int parent;
        Pair(int child, int parent){
            this.child=child;
            this.parent=parent;
        }
    }


    // Using DFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(detectDFS(i,-1,vis,adj))    return true;
            }
        }
        return false;
    }

    private boolean detectDFS(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]= true;

        for (int neighbour: adj.get(node)){
            if (!vis[neighbour]){
                if(detectDFS(neighbour,node, vis,adj))  return true;
            } else if (parent!=neighbour) {
                return true;
            }
        }
        return false;
    }



// Using BFS
    public boolean isCycle2(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(detect(i,vis,adj))    return true;
            }
        }
        return false;
    }

    private boolean detect(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,-1));         // It is starting node so parent is -1
        vis[src]= true;

        while (!q.isEmpty()){
            int node= q.peek().child;
            int parent= q.poll().parent;

            for (int adjNode: adj.get(node)){
                if (!vis[adjNode]){
                    vis[adjNode]=true;
                    q.offer(new Pair(adjNode,node));
                } else if (parent!=adjNode) {   // It means someone has already visited that node
                    return true;
                }
            }
        }
        return false;
    }
}

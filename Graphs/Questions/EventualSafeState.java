// https://leetcode.com/problems/find-eventual-safe-states/

package Graphs.Questions;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        boolean[] vis  = new boolean[m];
        boolean[] visPath  = new boolean[m];
        boolean[] safeNode = new boolean[m];
        for(int i=0; i<m; i++){
            if(!vis[i]){
                dfs(i,vis,visPath,safeNode,graph);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            if(safeNode[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    boolean dfs(int node, boolean[] vis, boolean[] visPath, boolean[] safeNode, int[][] graph){
        vis[node] = true;
        visPath[node] = true;

        for(int neighbour : graph[node]){
            if(!vis[neighbour]){
                if(!visPath[neighbour]){
                    if(dfs(neighbour, vis, visPath, safeNode, graph)) return true;
                }
            }
            else if(visPath[neighbour]){
                return true;
            }
        }
        visPath[node] = false;
        safeNode[node] = true;
        return false;
    }
}

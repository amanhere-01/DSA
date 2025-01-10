package Graphs.ImpAlgo;
//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
import java.util.*;

public class KruskalAlgo {

    public static void main(String[] args) {

    }

    static class Tuple implements Comparable<Tuple> {
        int src, dst, wt;

        Tuple(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.wt - o.wt;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Tuple> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int neigh = adj.get(i).get(j)[0];
                int wt = adj.get(i).get(j)[1];
                edges.add(new Tuple(i, neigh, wt));
            }
        }

        DisJointSet.DisjointSet ds = new DisJointSet.DisjointSet(V);
        Collections.sort(edges);
        int weightSum = 0;

        for (Tuple t : edges) {
            if (ds.findUltiPar(t.src) != ds.findUltiPar(t.dst)) {
                weightSum += t.wt;  // Accumulate the weights
                ds.unionBySize(t.src, t.dst);
            }
        }

        return weightSum;
    }
}

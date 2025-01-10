package Graphs.ImpAlgo;

import java.util.ArrayList;
//TC = 4 x alpha(almost constant)
public class DisJointSet {
    public static class DisjointSet{
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
    
        public DisjointSet(int n) {
            for(int i=0; i<=n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }
    
        public int findUltiPar(int node){
            if(parent.get(node)==node){
                return node;
            }
            int ultimateparent = findUltiPar(parent.get(node));
            parent.set(node, ultimateparent);
            return parent.get(node);
        }
    
        public void unionByRank(int u, int v){
            int ulp_u = findUltiPar(u);
            int ulp_v = findUltiPar(v);
    
            if(ulp_u==ulp_v) return;
            if(rank.get(ulp_u)<rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }
            else if(rank.get(ulp_v)<rank.get(ulp_u)){
                parent.set(ulp_v, ulp_u);
            }
            else{
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u)+1);
            }
        }
    
        public void unionBySize(int u, int v){
            int ulp_u = findUltiPar(u);
            int ulp_v = findUltiPar(v);
    
            if(ulp_u==ulp_v) return;
            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
            else{           // this would cover for both cases a) if size(u)>size(v) and b) if sizes equals
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2); 
        ds.unionByRank(2, 3); 
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7); 
        ds.unionByRank(5, 6); 
        
        // if 3 and 7 same lies in same set  or not 
        if(ds.findUltiPar(3) == ds.findUltiPar(7)) {
            System.out.println("Same"); 
        }
        else 
            System.out.println("Not Same"); 
            
        ds.unionByRank(3, 7); 

        if(ds.findUltiPar(3) == ds.findUltiPar(7)) {
            System.out.println("Same"); 
        }
        else 
            System.out.println("Not Same"); 

    }
}


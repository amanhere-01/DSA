// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

package Trees.Question;

import java.util.*;

class Pair{
    TreeNode node;
    int col;
    Pair(TreeNode node, int col){
        this.node= node;
        this.col=col;
    }
}

public class TopViewBinaryTree {
    static ArrayList<Integer> topView(TreeNode root) {
        TreeMap<Integer,Integer> map= new TreeMap();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int col= p.col;
            TreeNode node= p.node;
            
            if(!map.containsKey(col)){
                map.put(col,node.val);
            }
            if(node.left!=null){
                q.offer(new Pair(node.left,col-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,col+1));
            }

        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer val: map.values()){
            list.add(val);
        }
        
        return list;
    }
}

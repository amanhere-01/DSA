//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/


package Trees.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static List<List<Integer>> verticalTraversal(TreeNode root)
    {
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        insert(root,0,0,map);

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    
    static void insert(TreeNode node, int col, int row, TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map){
        if(node==null){
            return;
        }
        
        if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row, new PriorityQueue<>());
        }
        map.get(col).get(row).offer(node.val);

        insert(node.left, col-1, row+1, map);
        insert(node.right, col+1,row+1, map);
    }
}
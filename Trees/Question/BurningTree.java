//  https://www.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree
// This is almost same as https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

package Trees.Question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurningTree {
    static void setParent(Node node,HashMap<Node,Node> map ){
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    
    static Node findTarget(Node root, int target){
        if(root==null){
            return null;
        }
        
        if(root.val==target){
            return root;
        }
        
        Node left=findTarget(root.left,target);
        Node right= findTarget(root.right,target);
        
        return left==null ? right : left;
    }
    
    public static int minTime(Node root, int target) 
    {
        int k=0;
        HashMap<Node,Node> map = new HashMap<>();
        setParent(root,map);
        
        Node targetNode= findTarget(root, target);
        
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(targetNode);
        visited.add(targetNode);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Node curr= q.poll();
                
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if(map.containsKey(curr) && !visited.contains(map.get(curr))){
                    q.offer(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
            k++;
        }
        
        
        return k-1;
    }
}

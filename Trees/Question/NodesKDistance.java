package Trees.Question;

import java.util.*;

// We are gonna assign parents to the node then we do BFS
public class NodesKDistance {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();       // key = child, Value = parent
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        setParent(root);
        ArrayList<Integer> list = new ArrayList<>();
        bfs(target,k,list);
        return list;
    }

    // Assign the parent of nodes
    void setParent(TreeNode node){
        if(node==null){
            return;
        }

        if(node.left != null){
            parent.put(node.left,node);
        }
        setParent(node.left);

        if(node.right!=null){
            parent.put(node.right,node);
        }
        setParent(node.right);
    }

    // Now Add the left,right and parent node in queue level by level(BFS)
    void bfs(TreeNode target, int k, ArrayList<Integer> list){
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (k == 0) {
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                //Adding the left node in queue
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }

                //Adding the parent node in queue
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    queue.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }

                //Adding the right node in queue
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }
            }
            k--;
        }

        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
    }
}
















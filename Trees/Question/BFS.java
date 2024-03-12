package Trees.Question;

import java.util.*;

public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null){
            return ans;
        }


        queue.offer(root);
        while(queue.size()>0){
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                TreeNode currNode = queue.poll();
                list.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            ans.add(list);
        }

//        Collections.reverse(ans);   // to reverse this list we gotta wrote this command
        return ans;
    }
}

//https://leetcode.com/problems/symmetric-tree/

package Trees.Question;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
    // Recursive Solution
    public boolean isSymmetric(TreeNode root) {
        return traversal(root.left, root.right);
    }

    private boolean traversal(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }

        return traversal(left.left, right.right) && traversal(left.right, right.left);
    }


    // Iterative Solution
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }
            if(left ==null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }
}

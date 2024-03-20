//  https://leetcode.com/problems/sum-of-left-leaves/description/

package Trees.Question;

public class LeftLeaveSum {

    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,root);
        return sum;
    }
    private void helper(TreeNode node, TreeNode parent){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            if(node==parent.left){
                sum += node.val;
            }
        }

        helper(node.left, node);
        helper(node.right, node);

    }
}

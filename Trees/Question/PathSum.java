//  https://leetcode.com/problems/path-sum/description/

package Trees.Question;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root== null){
            return false;
        }
        return helper(root,0, targetSum);
    }

    private boolean helper(TreeNode node,int currSum ,int targetSum){
        if(node == null){
            return false;
        }
        currSum += node.val;
        if(node.left == null && node.right== null){
            return currSum== targetSum;
        }
        boolean left = helper(node.left,currSum,targetSum);
        boolean right = helper(node.right,currSum,targetSum);


        return left || right;
    }
}

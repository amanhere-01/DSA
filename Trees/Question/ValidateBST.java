//  https://leetcode.com/problems/validate-binary-search-tree/description/

package Trees.Question;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        // return helper(root, null, null);
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode node, long low, long high){
        if(node == null){
            return true;
        }
        if(node.val <= low || node.val >= high){
            return false;
        }

        boolean left = helper(node.left, low, node.val);
        boolean right = helper(node.right, node.val, high);
        return left && right;
    }

    //  We can also take Integer wrapper class with null
    private boolean helper2(TreeNode node, Integer low, Integer high){
        if(node == null){
            return true;
        }
        if(low!=null && node.val <= low){
            return false;
        }
        if(high!=null && node.val >= high){
            return false;
        }

        boolean left = helper(node.left, low, node.val);
        boolean right = helper(node.right, node.val, high);
        return left && right;
    }
}

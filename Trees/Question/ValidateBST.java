//  https://leetcode.com/problems/validate-binary-search-tree/description/

package Trees.Question;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode node, Integer low, Integer high){
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

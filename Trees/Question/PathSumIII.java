//  https://leetcode.com/problems/path-sum-iii/
package Trees.Question;

public class PathSumIII {
    // Approach:  We will treat every node as root node and solve it in a way ki find the path from root-to-leaf with targetSum

    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        dfs(root,targetSum);            // find the path from root-to-leaf for main root first then for left and right subtree
        pathSum(root.left,targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }

    private void dfs(TreeNode node, long sum){
        if(node==null) return;

        if(node.val==sum){
            ans++;
        }

        dfs(node.left,sum-node.val);
        dfs(node.right,sum-node.val);
    }
}

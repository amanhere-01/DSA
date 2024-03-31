//  https://leetcode.com/problems/longest-univalue-path/description/

package Trees.Question;

public class LongestUnivaluePath {
    int maxPath=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,root.val);
        return maxPath;
    }

    private int dfs(TreeNode node, int preValue){
        if(node==null){
            return 0;
        }
        int left= dfs(node.left, node.val);
        int right= dfs(node.right, node.val);

        maxPath= Math.max(maxPath, left+right);

        if(node.val==preValue){
            return Math.max(left,right) + 1;
        }

        return 0;
    }
}

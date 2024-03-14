package Trees.Question;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        // left or right will have p or q if the node is found otherwise it would have null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){  // It means left and right have node returned p or q
            return root;
        }

        if(right == null){      // It means the one node has been found on the left and right have given null
            return left;        // so it means the other node lies below left so instead of searching that node just return left as ot would be the ancestor
        }
        else{                   // For the else part right have been found and left is node so return right
            return right;
        }
    }
}

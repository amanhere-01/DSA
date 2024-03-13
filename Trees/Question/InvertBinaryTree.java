//  https://leetcode.com/problems/invert-binary-tree/description/

package Trees.Question;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // Both are same it's just that in this we create separate method for swapping
    public TreeNode invertTree2(TreeNode root) {
        swap(root);
        return root;
    }
    private void swap(TreeNode node){
        if(node == null){
            return;
        }
        swap(node.left);
        swap(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

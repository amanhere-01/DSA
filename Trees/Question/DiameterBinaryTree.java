package Trees.Question;

public class DiameterBinaryTree {

    int diameter=0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight ;
        diameter= Math.max(diameter,dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

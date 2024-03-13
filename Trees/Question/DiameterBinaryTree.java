package Trees.Question;

public class DiameterBinaryTree {

    int diameter=0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter  ;
    }

    private int height(TreeNode node){
        if(node == null){
            return -1;  
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 2;     // we are adding 2 because the laft and right node connect to parent node with 2 edges
        diameter= Math.max(diameter,dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

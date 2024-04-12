//  https://leetcode.com/problems/insert-into-a-binary-search-tree/

package Trees.Question.BST;

import Trees.Question.TreeNode;

public class InsertNodeInBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root== null){
            return new TreeNode(val);
        }
        set(root,root,val);
        return root;
    }

    private void set(TreeNode parent, TreeNode node, int val){
        if(node == null){
            TreeNode temp = new TreeNode(val);
            if(parent.left == null && val< parent.val){
                parent.left = temp;
            }else{
                parent.right= temp;
            }
            return;
        }

        if(val> node.val){
            set(node,node.right, val);
        }
        else{
            set(node,node.left,val);
        }
    }
}

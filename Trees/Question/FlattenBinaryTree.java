//  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package Trees.Question;

public class FlattenBinaryTree {

//  First we are check if left part of tree is null or not. If not null then traverse to the right end of the left subtree of currentNode and assign the right subtree of curentNode to that end
//  and then assign left subtree to the right part
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while(current !=null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while(temp.right !=null){
                    temp=temp.right;
                }
                temp.right= current.right;
                current.right = current.left;
                current.left=null;
            }
            current=current.right;
        }
    }


//  In this i am traversing to the bottom and then arranging it in Node->Left->Right
        public void flatten2(TreeNode root) {
            preOrder(root);
        }

        private TreeNode preOrder(TreeNode node){
            if(node == null){
                return null;
            }

            TreeNode left = preOrder(node.left);
            TreeNode right = preOrder(node.right);

            if(left!= null && right == null){
                node.right = node.left;
                node.left= null;
            }

            if(left!= null && right!= null){
                TreeNode temp = left;
                while(temp.right!=null){
                    temp= temp.right;
                }
                temp.right= right;
                node.right= left;
                node.left=null;
            }

            return node;
        }
}

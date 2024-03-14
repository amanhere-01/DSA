//  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package Trees.Question;

public class FlattenBinaryTree {




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

package Trees.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalDFS {

    //  --> Using stack
    //  Preorder is N->L->R
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);

            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return list;
    }

    //  Inorder is L->N->R
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else if(node == null){
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                list.add(node.val);
                node= node.right;
            }
        }
        return list;
    }
}

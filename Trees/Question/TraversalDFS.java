package Trees.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//  Iteration Method
public class TraversalDFS {
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

            if(root.right!=null){       // we have to add first right node
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

    //  Postorder is L->R->N
    //  Using 2 stack
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        st1.push(root);
        while (!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null){
                st1.push(root.left);
            }
            if(root.right != null){
                st1.push(root.right);
            }
        }

        while (!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }

}

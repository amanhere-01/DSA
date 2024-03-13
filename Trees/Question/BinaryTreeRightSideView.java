//  https://leetcode.com/problems/binary-tree-right-side-view/description/

package Trees.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root ==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int nodes = queue.size();
            for(int i=0; i<nodes; i++){
                TreeNode currNode = queue.poll();
                if(i== nodes-1){
                    list.add(currNode.val);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return list;
    }


// Recursion

    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<>();
    //     rightView(root, result, 0);
    //     return result;
    // }

    // private void rightView(TreeNode node, List<Integer> result, int level) {
    //     if (node == null) return;
    //     if (level == result.size()) {
    //         result.add(node.val);
    //     }
    //     rightView(node.right, result, level + 1);
    //     rightView(node.left, result, level + 1);
    // }
}

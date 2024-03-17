//  https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

package Trees.Question;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Integer> boundary(Node node) {
        if(!isLeafNode(node)){
            ans.add(node.val);
        }
        addLeftBoundary(node);
        addLeaf(node);
        addRightBoundary(node);
        return ans;
    }

    private boolean isLeafNode(Node node){
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(Node node) {
        Node currNode = node.left;
        while (currNode != null) {
            if (!isLeafNode(currNode)) {
                ans.add(currNode.val);
            }
            if (currNode.left != null) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
    }
    private void addLeaf(Node node){
        if (isLeafNode(node)){
            ans.add(node.val);
            return;
        }
        if (node.left != null){
            addLeaf(node.left);
        }
        if(node.right != null){
            addLeaf(node.right);
        }
    }

    private void addRightBoundary(Node node){
        Node currNode = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (currNode != null){
            if(!isLeafNode(currNode)){
                temp.add(currNode.val);
            }
            if(currNode.right != null){
                currNode = currNode.right;
            }else{
                currNode = currNode.left;
            }

            for(int i=temp.size()-1; i>=0; i--) {
                ans.add(temp.get(i));
            }
        }
    }


}

//  https://leetcode.com/problems/maximum-width-of-binary-tree/

package Trees.Question;

import java.util.LinkedList;
import java.util.Queue;

// We are assigning node their index value level by level. Root index is 0 and first node of every level will be assigned from 1
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int n){
        this.node= node;
        this.num= n;
    }
}
public class MaximumWidth {
    public int widthOfBinaryTree(TreeNode root) {
        int width=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while (!queue.isEmpty()){
            int size= queue.size();
            int minIndex = queue.peek().num;
            int first=0, last=0;
            for (int i=0; i<size; i++){
                assert queue.peek() != null;
                int newId = queue.peek().num - minIndex;
                //If we do not do this then on multiply with 2 the value would overflow so,we are subtracting the previously assigned index with min Index of that level
                // Instead of this we could also directly use long or unsigned int
                TreeNode node = queue.poll().node;

                if(i==0)  first= newId;
                if(i== size-1) last = newId;
                if (node.left != null){
                    queue.offer(new Pair(node.left, 2*newId +1));
                }
                if (node.right != null){
                    queue.offer(new Pair(node.right, 2*newId +2));
                }
            }
            width = Math.max(width, last-first+1);
        }
        return width;
    }
}

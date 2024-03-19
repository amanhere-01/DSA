//  https://leetcode.com/problems/binary-tree-paths/description/

package Trees.Question;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,new StringBuilder());
        return list;
    }

    private void helper(TreeNode node, StringBuilder str){
        if(node == null){
            return;
        }
        int val= node.val;
        int len = str.length();
        if(len>0){
            str.append( "->");
        }
        str.append(val);

        if(node.left==null && node.right== null){
            list.add(str.toString());
        }

        helper(node.left,str);
        helper(node.right, str);
        str.setLength(len);
    }
}

//  https://leetcode.com/problems/path-sum-ii/description/
package Trees.Question;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode node, int sum, ArrayList<Integer> list){
        if(node==null){
            return;
        }
        int size= list.size();
        list.add(node.val);


        if(node.val==sum && node.right==null&& node.left==null){
            ans.add(new ArrayList<>(list));     // Add a copy of list...if we do not add copy then when another answer hits it would modify the previous added list too
        }

        helper(node.left, sum-node.val,list);
        helper(node.right, sum-node.val,list);

        list.remove(size);
    }
}

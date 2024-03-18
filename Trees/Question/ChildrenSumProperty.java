//  https://www.geeksforgeeks.org/problems/children-sum-parent/1

package Trees.Question;

public class ChildrenSumProperty {
    public static int isSumProperty(Node root)
    {
        if(helper(root)){
            return 1;
        }else{
            return 0;
        }
    }

    private static boolean helper(Node root){
        if(root==null|| root.left == null && root.right == null){
            return true;
        }

        int left=0;
        if(root.left!=null){
            left= root.left.val;
        }

        int right=0;
        if(root.right!=null){
            right= root.right.val;
        }


        if(left+right==root.val){
            return helper(root.left) && helper(root.right);
        }

        return false;
    }
}

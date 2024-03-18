//  https://www.codingninjas.com/studio/problems/childrensumproperty_790723?leftPanelTabValue=SUBMISSION

package Trees.Question;

public class BinaryTreeToChildrenSumTree {
    public static void changeTree(TreeNode root) {
        if(root==null){
            return;
        }

        int sum=0;
        // Add to the sum variable
        if(root.left != null){
            sum += root.left.val;
        }
        if(root.right != null){
            sum += root.right.val;
        }

//      Now compare with root
        if(sum >= root.val){
            root.val = sum;
        }
        else{       // if sum < root.data
            if(root.left != null){
                root.left.val = root.val;
            }
            if(root.right != null){
                root.right.val = root.val;
            }
        }

        // Now do recursion
        changeTree(root.left);
        changeTree(root.right);

        // After coming from root again change the value of parent
        int newSum=0;
        if(root.left != null){
            newSum += root.left.val;
        }
        if(root.right != null){
            newSum += root.right.val;
        }

        if(root.left != null || root.right != null){
            root.val = newSum;
        }

    }
}

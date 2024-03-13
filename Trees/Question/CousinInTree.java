package Trees.Question;

public class CousinInTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && !isSibling(root, xx, yy));
    }

    private TreeNode findNode(TreeNode node, int val){
        if(node == null){
            return null;
        }
        if (node.val == val){
            return node;
        }
        TreeNode n = findNode(node.left, val);
        if(n != null){
            return n;
        }
        return findNode(node.right, val);
    }

    private int level(TreeNode node, TreeNode x, int level){
        if(node == null){
            return 0;
        }
        if (node == x){
            return level;
        }
        int l = level(node.left, x, level+1);
        if(l!=0){
            return l;
        }
        return level(node.right, x, level+1);
    }

    private boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy){
        if(node == null){
            return false;
        }


//        if(node.left == xx && node.right == yy || node.left == yy && node.right == xx){
//            return true;
//        }
//
//        boolean b = isSibling(node.left, xx, yy);
//        if(b){
//            return true;
//        }
//        return isSibling(node.right, xx, yy);

        // or we can do this instead of writing above long code
        return (
                (node.left == xx && node.right == yy) || (node.left == yy && node.right == xx) || isSibling(node.left,xx,yy) || isSibling(node.right, xx,yy)
        );
    }
}

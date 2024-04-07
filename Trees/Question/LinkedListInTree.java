//  https://leetcode.com/problems/linked-list-in-binary-tree/

package Trees.Question;

import LinkedList.Questions.ListNode;

public class LinkedListInTree {
    // Treat every node as root node and do traverse from there

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);  // check for main root node if it is false then treat left node as root and do traverse 
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) return true; // Reached the end of the list, so it's a subpath
        if (node == null) return false; // Reached the end of the tree without finding a match

        if (node.val == head.val) {
            // Check if the rest of the list matches starting from this node in the tree
            return dfs(node.left, head.next) || dfs(node.right, head.next);
        }

        // If the current node doesn't match, continue searching in the tree
        return false;
    }
}

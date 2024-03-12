//  https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

package Trees.Question;

public class ConnectingNodes {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }

        Node leftMost = root;
        while(leftMost.left!=null){
            Node currNode = leftMost;

            while(currNode !=null){
                currNode.left.next = currNode.right;
                if(currNode.next!=null){
                    currNode.right.next = currNode.next.left;
                }
                currNode= currNode.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

//  Using recursion

    // public Node connect(Node root) {
    //     if(root == null)
    //         return null;

    //     if(root.left != null)
    //         root.left.next = root.right;

    //     if(root.right != null && root.next != null)
    //         root.right.next = root.next.left;

    //     connect(root.left);
    //     connect(root.right);

    //     return root;
    // }



//  My approach using BFS algo

    // public Node connect(Node root) {
    //     if(root==null){
    //         return root;
    //     }

    //     Queue<Node> queue = new LinkedList<>();
    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int countNodes = queue.size();

    //         for(int i=0; i< countNodes; i++){
    //             Node currNode = queue.poll();
    //             if(i== countNodes-1){
    //                 currNode.next = null;
    //             }
    //             else{
    //                 currNode.next = queue.peek();
    //             }

    //             if (currNode.left != null) {
    //                 queue.offer(currNode.left);
    //             }
    //             if (currNode.right != null) {
    //                 queue.offer(currNode.right);
    //             }
    //         }
    //     }

    //     return root;
    // }
}

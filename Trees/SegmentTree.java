package Trees;

public class SegmentTree {
    public static void main(String[] args) {

    }


    public static class Node{
        int data;
        int startIndex;
        int endIndex;
        Node left;
        Node right;

        public Node(int startIndex, int endIndex ){
            this.startIndex =startIndex;
            this.endIndex= endIndex;
        }
    }

    Node root;
    public SegmentTree (int[] arr){
        this.root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start==end){
            // It means we are at leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // create new node with index you are at
        Node node = new Node(start, end);
        int mid = (start+end)/2;
        node.left = constructTree(arr, start, mid);
        node.right= constructTree(arr, mid+1, end);

        // Updating the node data
        node.data = node.left.data + node.right.data;

        return node;
    }

}

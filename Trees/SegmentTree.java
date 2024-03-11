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

    // query ( we might be given that find sum of arr range b/w qsi- qei)   qsi= query Start Index
    public int query( int qsi,int qei){
        return query(this.root , qsi, qei);
    }

    private int query(Node node, int qsi , int qei){
        if(node.startIndex>= qsi && node.endIndex <= qei){
            // node range is completely lying inside query range
            return node.data;
        }
        else if( node.startIndex > qei || node.endIndex < qsi){
            // query range is outside of interval
            return 0;
        }
        else {
            // query range lying half in node range
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }


    // Update
    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value){
        if (index >= node.startIndex && index <= node.endIndex){
            if(index == node.startIndex && index == node.endIndex){
                node.data = value;
                return node.data;
            }
            else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }

        }

        return node.data;
    }

    // Display
    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startIndex + "-" + node.left.endIndex + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startIndex + "-" + node.endIndex + "] and data: " + node.data + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startIndex + "-" + node.right.endIndex + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }
}

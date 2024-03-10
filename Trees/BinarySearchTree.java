package Trees;

public class BinarySearchTree {
    public BinarySearchTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value){
            this.value= value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }


    // Inserting non sorted array
    public void populate(int [] nums){
        for(int num: nums){
            insert(num);
        }
    }

    // Inserting sorted array
    public void populateSort(int[] nums){
        populateSort(nums, 0, nums.length);
    }
    private void populateSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;
        // Inserting the left part
        populateSort(nums, 0, mid);
        // Inserting the right part
        populateSort(nums, mid+1, end);
    }

    private void insert(int value){
        root = insert(value, root);
    }
    private Node insert(int value , Node node){
        if(node==null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height= Math.max(height(node.left) , height(node.right)) + 1;

        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

    // Display
    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if (node==null){
            return;
        }
        System.out.println(details+ node.getValue());

        display(node.left, "Left child of " + node.getValue()+ " : ");
        display(node.right, "Right child of " + node.getValue()+ " : ");
    }

}

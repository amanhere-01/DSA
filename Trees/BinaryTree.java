package Trees;

import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;

    // Inserting
    public void populate(Scanner sc){
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root= new Node(value);
        populate(sc , root);
    }

    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to add left of " + node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of "+ node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to add right of " + node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of "+ node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }

    //  Displaying
    public void display(){
        display(this.root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(this.root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        prettyDisplay(node.right , level+1);
        if(level!=0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.value);
        }
        else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);
    }

    // Traversal
    public void preOrder(){
        //  Preorder is N->L->R
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        //  Preorder is L->N->R
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(){
        //  Preorder is L->R->N
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");

    }

}

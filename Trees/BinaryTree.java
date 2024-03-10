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

    public void populate(Scanner sc, Node node){
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

    //
}

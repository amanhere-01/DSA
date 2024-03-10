package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(sc);
//        tree.prettyDisplay();


        BinarySearchTree bst = new BinarySearchTree();
        bst.populate( new int[]{ 2,7,1,4,8,5,10});
        bst.display();
    }
}

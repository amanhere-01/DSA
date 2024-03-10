package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(sc);
//        tree.prettyDisplay();


//        BinarySearchTree bst = new BinarySearchTree();
//        bst.populate( new int[]{ 2,7,1,4,8,5,10});
//        bst.display();

        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < 1000; i++) {
            avlTree.insert(i);
        }
        System.out.println(avlTree.height());       // height code have some error
    }
}

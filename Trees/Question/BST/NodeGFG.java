package Trees.Question.BST;


public class NodeGFG {
    int data;
    NodeGFG left;
    NodeGFG right;
    NodeGFG() {}

    NodeGFG(int val) { this.data = val; }

    NodeGFG(int val, NodeGFG left, NodeGFG right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

package LinkedList.DoublyLL;

public class DLL {
    private Node head;
    private int size;

    public DLL() {
        this.size = 0;
    }
    public void size(){
        System.out.println(size);
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next= head;
        node.prev = null;
        if(head!=null){
            head.prev = node;
        }
        head= node;
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;
        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        size++;
    }

    public void insert(int after, int val) {        // inserting a node after a node with value=val
        Node p = findNode(after);
        if (p == null) {
            System.out.println("does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

    public Node findNode(int val) {
        Node node = head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display(){
        Node temp= head;
        while (temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void reverseDisplay(){
        Node temp= head;
        Node last=null;
        while (temp!=null){
            last=temp;
            temp=temp.next;
        }
        while (last!=null){
            System.out.print(last.value + " ");
            last=last.prev;
        }
        System.out.println();
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next , Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}

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

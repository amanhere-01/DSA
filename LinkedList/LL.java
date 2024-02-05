package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }
    public void size(){
        System.out.println(size);
    }
    public void insertFirst(int value ){
        Node node = new Node(value);
        node.next = head;
        head= node;

        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLast(int value ){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail= node;
        size++;
    }

    public void insert(int val, int index){
        if(index==0){
            insertFirst(val);
        }
        if(index==size){
            insertLast(val);
        }
        Node temp = head;
        for(int i=1; i<index; i++){     // temp will traverse till index-1
            temp= temp.next;
        }
        Node node = new Node(val,temp.next );   // now creating and setting reference for new node
        temp.next=node;                         // setting the reference of current temp node to new node
        size++;

    }

    public void display(){
        Node temp = head;
        while ((temp!=null)){
            System.out.print(temp.value + " ");
            temp= temp.next;
        }
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

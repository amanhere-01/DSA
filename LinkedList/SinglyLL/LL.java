package LinkedList.SinglyLL;

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
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){     // temp will traverse till index-1
            temp= temp.next;
        }
        Node node = new Node(val,temp.next );   // now creating and setting reference for new node
        temp.next=node;                         // setting the reference of current temp node to new node
        size++;

    }

    public int deleteFirst(){
        int val = head.value;
        head=head.next;
        if(head==null){     // if there is only onw node present
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = getNode(size-2);    // basically this func will traverse to the node at index = size-2
        int val = tail.value;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;
    }

    public int delete(int index){
        if (index==0){
            return deleteFirst();
        }
        if (index==size-1){
            return deleteLast();
        }
        Node prev= getNode(index-1);
        int val = prev.next.value;
        prev.next=prev.next.next;
        size--;
        return val;
    }

    public Node findNode(int val){    // finding node whose value is val
        Node temp = head;
        while (temp!=null){
            if(temp.value==val){
                return temp;
            }
            temp=temp.next;
        }
        // if there is no node of value val then return null
        return null;
    }
    public Node getNode(int index){
        Node temp= head;
        for(int i=0; i<index; i++){
            temp= temp.next;
        }
        return temp;
    }
    public void display(){
        Node temp = head;
        while ((temp!=null)){
            System.out.print(temp.value + " ");
            temp= temp.next;
        }
        System.out.println();
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

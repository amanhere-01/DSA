package LinkedList.SinglyLL;

public class LL {

    public Node head;
    public Node tail;
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

    // Insertion using recursion
    public void insertRec(int val, int index){
        head = insertRec(val,index,head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index==0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next= insertRec(val, index-1 , node.next);
        return node;
    }

    // Reverse using Recursion
    public void reverse(Node node){
    //  Here first reaching till the tail then reversing after recursion calls get out
        if(node==tail){
            head=tail;
            return;
        }

        reverse(node.next);     // When node.next= tail then above function calls and return then at that time node is previous of tail
        tail.next= node;
        tail=node;
        tail.next=null;

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

    public static class Node{
        public int value;
        public Node next;

        public Node(){}
        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

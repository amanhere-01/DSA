package LinkedList.DoublyLL;


public class Main {
    public static void main(String[] args) {
        DLL list= new DLL();
        list.insertFirst(21);
        list.insertFirst(31);
        list.insertFirst(41);
        list.insertFirst(51);
        list.insertFirst(61);
        list.insertLast(100);
        list.display();
        list.insert(41, 99);
        list.display();

//        list.reverseDisplay();
        list.size();
    }
}

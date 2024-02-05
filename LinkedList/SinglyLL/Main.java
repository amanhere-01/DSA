package LinkedList.SinglyLL;

public class Main {
    public static void main(String[] args) {

        LL list= new LL();
        list.insertFirst(21);
        list.insertFirst(31);
        list.insertFirst(41);
        list.insertFirst(51);
        list.insertFirst(61);
        list.insertLast(11);
        list.display();
        list.insert(100,5);
        list.display();
        System.out.println(list.deleteFirst() + " deleted");
        list.display();
        System.out.println(list.deleteLast() + " deleted");
        list.display();
        System.out.println(list.delete(3));
        list.display();
        list.size();

    }
}

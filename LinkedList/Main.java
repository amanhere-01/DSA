package LinkedList;

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
        System.out.println();
        list.insert(100,5);
        list.display();
        System.out.println();
        list.size();

    }
}

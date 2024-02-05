package LinkedList.CircularLL;

public class Main {
    public static void main(String[] args) {

        CLL list = new CLL();
        list.insert(21);
        list.insert(1);
        list.insert(43);
        list.insert(65);
        list.insert(77);
        list.display();
        list.delete(43);
        list.display();
    }
}

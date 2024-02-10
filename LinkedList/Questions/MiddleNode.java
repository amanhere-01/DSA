package LinkedList.Questions;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}

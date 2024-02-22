//  https://leetcode.com/problems/odd-even-linked-list/description/

package LinkedList.Questions;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd= head;
        ListNode even = head.next;
        ListNode evenHead= even;
        // even will always be ahead of odd
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}

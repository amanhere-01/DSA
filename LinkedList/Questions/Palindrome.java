//  https://leetcode.com/problems/palindrome-linked-list/

package LinkedList.Questions;

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // copy the list
        ListNode head1= null;
        ListNode temp= null;
        ListNode temp2= head;
        while(temp2!=null){
            ListNode node= new ListNode(temp2.val);
            if(head1==null){
                head1= node;
            }else{
                temp.next=node;
            }
            temp= node;
            temp2= temp2.next;
        }
        head= rev(head);
        while(head1!=null ){
            if(head1.val!= head.val){
                return false;
            }
            head1= head1.next;
            head= head.next;
        }
        return true;
    }

    ListNode rev(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev= null;
        ListNode current= head;
        ListNode next= current.next;
        while(current!=null){
            current.next=prev;
            prev= current;
            current= next;
            if(next!=null){
                next= next.next;
            }
        }
        return prev;
    }
}

//  https://leetcode.com/problems/palindrome-linked-list/

package LinkedList.Questions;

public class Palindrome {
//  This method is find the middle node and reverse the LL from there and compare between them
//  Suppose a list = [1,2,3,4,5] and list2= [1,2,3,4]
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid= middleNode(head); // here mid= 3
        ListNode secondHead= rev(mid);
// NOTE:
// Now that we have reversed the list from mid then when we print head node till null, it will be [1,2,3]. After reversing original list changes.
// For list2 printing head till null will give [1,2,3]
// When we print secondHead till temp , it will be [5,4,3] . For list2 it will give [4,3]
// So the mid node will be included in both
        while(head!=null && secondHead!=null){
            if(head.val!= secondHead.val){
                return false;
            }
            head=head.next;
            secondHead= secondHead.next;
        }

        return true;
    }

    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }


//  This method is first copy the given LL then reverse the given LL and now compare them
    public boolean isPalindrome2(ListNode head) {
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

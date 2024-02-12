//  https://leetcode.com/problems/rotate-list/

package LinkedList.Questions;

public class RotateList {

    public ListNode rotateRightt(ListNode head, int k) {
        if(head==null || head.next == null || k==0){
            return head;
        }
        // Find number of nodes
        int size =1;
        ListNode last= head;
        while(last.next!=null){
            last=last.next;
            size++;
        }
        last.next= head;

        int rotations = k%size;
        int skip= size - rotations;
        ListNode newEnd= head;
        for(int i=0; i< skip-1 ; i++){
            newEnd= newEnd.next;
        }

        head= newEnd.next;
        newEnd.next= null;

        return head;

    }

//  Basically my approach is first reverse list then break it to 2 list from where it is asked and then reverse both parts then connect it at the end
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null ){
            return head;
        }
        // Find number of nodes
        int size =0;
        ListNode count= head;
        while(count!=null){
            count=count.next;
            size++;
        }
        // If k is multiple of size then return head
        if(k%size==0){
            return head;
        }
        // Reverse the whole list
        head= rev(head);
        ListNode ef = head;
        ListNode temp= head;    // traversing the temp in reversed list till K and from there break into two list by doing temp.next=null
        for(int i=1; i<k%size ; i++){
            temp= temp.next;
        }
        ListNode hs =rev(temp.next);    // reversing second half list

        temp.next=null;     // breaking list into two list
        head= rev(head);    // reversing the first half
        ef.next= hs;        // connecting both halves
        return head;

    }

    ListNode rev(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode current= head;
        ListNode next= current.next;

        while(current!=null){
            current.next=prev;
            prev=current;
            current=next;
            if(next!= null){
                next=next.next;
            }
        }
        return prev;
    }
}

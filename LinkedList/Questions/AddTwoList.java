//  https://leetcode.com/problems/add-two-numbers/description/

package LinkedList.Questions;

public class AddTwoList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode tail=head;;

        int carry=0;
        while(l1!=null || l2!=null || carry>0){     // Instead of iterating for separate list we can do this
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum += carry;
            ListNode node = new ListNode(sum % 10);
            if(head==null){
                head=node;
                tail=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            carry=sum/10;
        }

        return head;
    }

    // This is my code and it most optimized one

     public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
         ListNode head=null;
         ListNode tail=head;;

         int carry=0;
         while(l1!=null && l2!=null){
             int sum=l1.val+l2.val+carry;
             carry=sum/10;
             ListNode node = new ListNode(sum % 10);
             if(head==null){
                 head=node;
                 tail=node;
             }
             else{
                 tail.next=node;
                 tail=node;
             }
             l1=l1.next;
             l2=l2.next;
         }
         while(l1!=null){
             int sum=l1.val+carry;
             carry= sum/10;
             ListNode node = new ListNode(sum % 10);
             tail.next=node;
             tail=node;
             l1=l1.next;
         }
         while(l2!=null){
             int sum=l2.val+carry;
             carry= sum/10;
             ListNode node = new ListNode(sum % 10);
             tail.next=node;
             tail=node;
             l2=l2.next;
         }
         if(carry>0){
             tail.next= new ListNode(carry);
         }
         return head;
     }
}

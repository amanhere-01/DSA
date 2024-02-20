//  https://leetcode.com/problems/intersection-of-two-linked-lists/

package LinkedList.Questions;

public class YIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode t1= headA;
        ListNode t2= headB;
        while(t1!=t2){
            t1= t1.next;
            t2= t2.next;
            if(t1==t2){
                return t1;
            }
            if(t1==null){
                t1= headB;
            }
            if(t2==null){
                t2=  headA;
            }

        }
        return t1;
    }


    // Other method

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode temp1 = headA;
    //     ListNode temp2= headB;
    //     int size1= count(temp1);
    //     int size2 = count(temp2);

    //     if(size2>size1){
    //         for(int i=0;i<size2-size1; i++){
    //             headB= headB.next;
    //         }
    //     }
    //     else{
    //         for(int i=0;i<size1-size2; i++){
    //             headA= headA.next;
    //         }
    //     }
    //     while(headA!=headB){
    //         headA=headA.next;
    //         headB=headB.next;
    //     }

    // return headA;
    // }

    // public int count(ListNode temp){
    //     int size=0;
    //     while(temp!=null){
    //         size++;
    //         temp=temp.next;
    //     }
    //     return size;
    // }
}

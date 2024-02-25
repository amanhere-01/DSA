// Find the first greater element to the right of any number in arr. Return -1 if no greater element found
//QUESTION RELATED TO THIS https://leetcode.com/problems/next-greater-element-i/description/
package Stack.Question;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatRIght {
    public static void main(String[] args) {
        int[] nums= {1,6,3,5,4,2};
        int[] nums2= {0,4,1,2,3,5};
        System.out.println(Arrays.toString( NextGreaterRight(nums)));
        System.out.println(Arrays.toString( NextGreaterRight(nums2)));
        System.out.println(Arrays.toString( NextGreaterRight2(nums)));
    }

    //  Traversing from right to left
    // here we start from end and first we will push the end element into the stack and mark the ngr[end]=-1
    // So basically what we do is we will pop the element in the stack until the element is greater than the arr[i]
    // Now if we found greater element than arr[i] in the stack then mark ngr[i]=top element in the stack and push the arr[i]
    static int[] NextGreaterRight(int[] arr){
        int[] ngr = new int[arr.length];
        Stack <Integer> st= new Stack<>();

        st.push(arr[arr.length-1]);
        ngr[arr.length-1]=-1;

        for(int i= arr.length-2; i>=0; i--){
            while (!st.isEmpty() && arr[i]> st.peek()){     // If array has duplicates then this condition will be-- while(!st.isEmpty() && arr[i]>=st.peek())
                st.pop();
            }
            if(st.isEmpty()){
                ngr[i]=-1;
            }
            if(!st.isEmpty()){
                ngr[i]= st.peek();
            }
            st.push(arr[i]);
        }
        return ngr;
    }


    // Traversing left to right (Another method)
    // here starting from index 0 and firstly we push the index 0 in the stack and start traversing from arr[1]
    // now if arr[i] is greater than the arr[at index at top of stack] then we pop it and mark the ngr[index at top of stack]=arr[i] as arr[i] is greater and it removed the arr[at index at top of stack] and then push the ith index
    // and if arr[i] is not greater than simply push the ith index
    static int[] NextGreaterRight2(int[] arr){
        int[] ngr = new int[arr.length];
        Stack <Integer> st= new Stack<>();

        st.push(0);

        for(int i= 1; i<arr.length; i++){
            while (!st.isEmpty() && arr[i]> arr[st.peek()]){     // If array has duplicates then this condition will be-- while(!st.isEmpty() && arr[i]>=st.peek())
                ngr[st.peek()]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size()>0){
            ngr[st.peek()]=-1;
            st.pop();
        }

        return ngr;
    }
}

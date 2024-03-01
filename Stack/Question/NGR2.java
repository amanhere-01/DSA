//  https://leetcode.com/problems/next-greater-element-ii/description/

package Stack.Question;

import java.util.Stack;

// now here it is circular array
public class NGR2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        nextGreaterElements(arr);
    }

    static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i= nums.length-1; i>=0; i--){
            st.push(nums[i]);
        }
        for(int i= nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[i]>= st.peek()){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=st.peek();
            }else{
                ans[i]=-1;
            }
            st.push(nums[i]);
        }

        return ans;
    }


//  My method using ngr 1
    // static int[] nextGreaterElements(int[] nums) {
    //     int len = nums.length;
    //     int[] arr = new int[2*len];
    //     for(int i=0; i<2*len; i++){
    //         arr[i]=nums[i%len];
    //     }
    //     return NGR(arr);
    // }

    // static int[] NGR(int [] arr){
    //     int[] ngr = new int[arr.length];
    //     Stack <Integer> st= new Stack<>();

    //     st.push(arr[arr.length-1]);
    //     ngr[arr.length-1]=-1;

    //     for(int i= arr.length-2; i>=0; i--){
    //         while (!st.isEmpty() && arr[i]>= st.peek()){
    //             st.pop();
    //         }
    //         if(st.isEmpty()){
    //             ngr[i]=-1;
    //         }
    //         if(!st.isEmpty()){
    //             ngr[i]= st.peek();
    //         }
    //         st.push(arr[i]);
    //     }
    //     return Arrays.copyOfRange(ngr,0,ngr.length/2);
    // }
}

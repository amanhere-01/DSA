//  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
package Stack.Question;

import java.util.Stack;

public class RemoveDuplicate {

    public static void main(String[] args) {

    }


    //  Using 1 stack
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
//      In the stack we are pushing array. array[0] holds the char(as an integer) and array[1] holds the count of char
        char[] arr = s.toCharArray();
        for(int j = arr.length-1; j>=0; j--){
            if(!st.isEmpty() && st.peek()[0] == arr[j]){    // st.peek()[0] It means at position 0 in array if character == arr[j]
                // And here we are comparing char to an int (st.peek()[0] == arr[j]) In Java, when you compare a char to an int, the char is implicitly promoted to an int
                st.peek()[1]++;     // Increasing the value of count
            }else{
                st.push(new int[]{arr[j],1});   // char will be fed in array stack as an integer
            }

            if(st.peek()[1]==k){
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            int[] top= st.pop();
//          top[0] holds the character (as an integer) and top[1] holds the count of that character.
            while(top[1]-- > 0){
                sb.append((char) top[0]);
            }
        }
        return sb.toString();
    }


    //  USing 2 stacks
    // public String removeDuplicates(String s, int k) {
    //     Stack<Integer> count = new Stack<>();
    //     Stack<Character> st = new Stack<>();
    //     char[] arr = s.toCharArray();
    //     for(int j = arr.length-1; j>=0; j--){
    //         if(!st.isEmpty() && arr[j]== st.peek()){
    //             st.push(arr[j]);
    //             int c = count.pop();
    //             count.push(c+1);
    //         }else{
    //             st.push(arr[j]);
    //             count.push(1);
    //         }

    //         if(count.peek()==k){
    //             count.pop();
    //             for(int i=0; i<k; i++){
    //                 st.pop();
    //             }
    //         }
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     while(!st.isEmpty()){
    //         sb.append(st.pop());
    //     }
    //     return sb.toString();
    // }
}

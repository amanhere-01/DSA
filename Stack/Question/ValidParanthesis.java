//  https://leetcode.com/problems/valid-parentheses/description/

package Stack.Question;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "({[]})";
        String s4 = "({[}])";
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }

    static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        int length= s.length();
        for(int i=0; i<length; i++){
            char ch =s.charAt(0);
            if(ch=='('){
                st.push(')');
            }
            else if(ch=='{' ){
                st.push('}');
            }
            else if(ch=='['){
                st.push(']');
            }
            else if(st.isEmpty() || st.pop()!=ch){
                return false;
            }
            s=s.substring(1);
        }

        return st.isEmpty();
    }


    // public boolean isValid(String s) {
    //     if(s.length()==1){
    //         return false;
    //     }
    //     Stack<Character> st = new Stack<>();
    //     int length= s.length();
    //     for(int i=0; i<length; i++){
    //         if(s.charAt(0)=='(' || s.charAt(0)=='{' || s.charAt(0)=='['){
    //             st.push(s.charAt(0));
    //         }
    //         if(s.charAt(0)=='}'){
    //             if(st.size()>0 && st.peek()=='{'){
    //                 st.pop();
    //             }
    //             else{
    //                 return false;
    //             }
    //         }
    //         if(s.charAt(0)==']'){
    //             if( st.size()>0 && st.peek()=='['){
    //                 st.pop();
    //             }
    //             else{
    //                 return false;
    //             }
    //         }
    //         if(s.charAt(0)==')'){
    //             if(st.size()>0 && st.peek()=='('){
    //                 st.pop();
    //             }
    //             else{
    //                 return false;
    //             }
    //         }

    //         s= s.substring(1);
    //     }


    //     return st.isEmpty();
    // }
}

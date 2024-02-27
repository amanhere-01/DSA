//  https://leetcode.com/problems/valid-parentheses/description/

package Stack.Question;

import java.util.Stack;

public class ValidParanthesis {
    // If we use substring then it would take more time so use char array
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
        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='{'|| ch=='[' ){
                st.push(ch);
            }
            else{
                if(ch==')'){
                    if(st.isEmpty() || st.pop()!='('){
                        return false;
                    }
                }
                if(ch=='}'){
                    if(st.isEmpty() || st.pop()!='{'){
                        return false;
                    }
                }
                if(ch==']'){
                    if(st.isEmpty() || st.pop()!='['){
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }



    static boolean isValid2(String s){
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

}

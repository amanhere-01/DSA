package Stack.Question;

import java.util.Stack;

public class StringDecode {

    public static void main(String[] args) {
        String s = "3[a]11[bc]";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char ch : arr) {
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    sb.insert(0, st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                    StringBuilder numBuilder = new StringBuilder();
                    while (!st.isEmpty() && Character.isDigit(Integer.parseInt(st.peek()))) {       // Or use this- while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))
                        numBuilder.insert(0, st.pop());
                    }
                    int num = Integer.parseInt(numBuilder.toString());
                    String temp = sb.toString();
                    for (int i = 1; i < num; i++) {
                        sb.append(temp);
                    }
                    st.push(sb.toString());
                }

            } else {
                st.push(Character.toString(ch));
            }
        }
        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }
}

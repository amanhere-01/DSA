package Stack.Question;

import java.util.Stack;

public class StringDecode {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char ch : arr) {
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
//                String temp = st.peek();
                while (!st.isEmpty() && !st.peek().equals("[") ) {
                    sb.insert(0, st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                    int num = Integer.parseInt(st.pop());
                    for (int i = 1; i < num; i++) {
                        sb.append(sb);
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

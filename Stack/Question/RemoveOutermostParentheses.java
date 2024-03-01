//  https://leetcode.com/problems/remove-outermost-parentheses/description/

package Stack.Question;

public class RemoveOutermostParentheses {

    // Without Stack
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }

            if (count == 1 && ch == '(' || count == 0 && ch == ')') {
                continue;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    
    // Using Stack
    // Push the chars along with appending the string

    // public String removeOuterParentheses(String s) {
    //     Stack<Character> st = new Stack<>();
    //     StringBuilder ans = new StringBuilder();
    //     for (char ch : s.toCharArray()) {
    //         if (ch == '(') {
    //             if (st.size() > 0) {
    //                 ans.append(ch);
    //             }
    //             st.push(ch);

    //         } else {
    //             if (st.size() > 1) {
    //                 ans.append(ch);
    //             }
    //             st.pop();

    //         }
    //     }
    //     return ans.toString();
    // }
}

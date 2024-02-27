//  https://leetcode.com/problems/min-stack/description/

package Stack.Question;

import java.util.Stack;

public class minStack {

}

class MinStack {

    Long min = Long.MAX_VALUE;
    Stack<Long> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        Long value= (long) val;
        if(st.isEmpty()){
            min=value;
            st.push(value);
        }
        else{
            if(value<min){
                st.push(2*value - min);
                min=value;
            }else{
                st.push(value);
            }
        }
    }

    public void pop() {
        if(st.isEmpty()) return ;

        Long a =st.pop();
        if(a<min){
            min= 2*min - a;
        }
    }

    public int top() {
        Long a =st.peek();
        if(a<min){
            return min.intValue();
        }
        return a.intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}

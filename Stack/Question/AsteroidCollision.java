//  https://leetcode.com/problems/asteroid-collision/description/

package Stack.Question;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] a1 = {5,10,-5};
        int[] a2 = {8,-8};
        int[] a3 = {-2,-1,1,2};
        int[] a4 = {1,-2,10,-5};
        int[] a5 = {1,-2,10,5};
        int[] a6 = {-1,2,10,5};

        System.out.println(Arrays.toString(asteroidCollision(a5)));
    }


    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int num : asteroids) {
            if (num > 0) {
                st.push(num);
            } else {            // for num<0

                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -num) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) { // negative num will be pushed if the stack is empty or st.top() is <0
                    st.push(num);
                }
                if (!st.isEmpty() && st.peek() == -num) {
                    st.pop();
                }
            }
        }
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

}

// if we encounter +ve num then push it into stack
// if num<0 and stack is empty or top of stack is <0 then push it
// if num>0 and st.top<0 then it will not collide that's why we pushed it
// The collision occurs only when the st.top>0 and num<0
// if num<0 and st.top()>0 then check the magnitude if st.top is greater than
// num then don't pop
// if num<0 and st.top()>0 then check the magnitude if st.top is lesser than num
// then pop it

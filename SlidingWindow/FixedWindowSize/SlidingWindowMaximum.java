//  https://leetcode.com/problems/sliding-window-maximum/description/
//  Return the max element in k window size

package SlidingWindow.FixedWindowSize;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        int [] ans = new int[nums.length-k+1];
        Deque<Integer> list = new ArrayDeque<>();
        int i=0, v=0;

        for(int j=0; j< nums.length; j++){
            // Make a queue and add the max elements into that list. (Kind of next greater right element)
            if (list.size()>0 ){
                while(list.size()>0 && nums[j]>list.peekLast()){        // Pop the last element from list until it is greater than nums[j]
                    list.removeLast();
                }
                list.add(nums[j]);
            }else {
                list.add(nums[j]);
            }


            if( j-i+1 ==k){                 // j-i+1 is the window size
                ans[v++] = list.peekFirst();

                // Now slide the window
                if (list.size()>0 &&  nums[i] == list.peekFirst()){
                    list.removeFirst();
                }
                i++;
            }
        }
        return ans;
    }
}

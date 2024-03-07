package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(slidingMaximum(arr , 3));
    }

    static List<Integer> slidingMaximum(final int[] arr, int k) {
        ArrayDeque<Integer> maxList= new ArrayDeque<>();
        ArrayList<Integer> ans =new ArrayList<>();
        int i=0, j=0;

        while(j< arr.length){
            if(maxList.size()>0){
                while (!maxList.isEmpty() && arr[j]> maxList.peekLast()){
                    maxList.removeLast();
                }
                maxList.addLast(arr[j]);
            }else {
                maxList.add(arr[j]);
            }

            if(k > j-i+1){
                j++;
            }

            else if ( k== j-i+1){
                ans.add(maxList.peekFirst());

                // sliding the window
                if (!maxList.isEmpty() && arr[i] == maxList.peekFirst()){
                    maxList.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}

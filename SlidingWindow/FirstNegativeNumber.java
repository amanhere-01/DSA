//  https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

package SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {

    public static void main(String[] args) {
        long []A = {-8, 2, 3, -6, 10};
        System.out.println(Arrays.toString(printFirstNegativeInteger(A, 5, 2)));
    }


    static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] arr = new long[N-K+1];
        Queue<Long> queue = new LinkedList<>();
        int i=0, j=0;
        int a=0;
        while(j<N){
            if(A[j]<0){
                queue.add(A[j]);
            }
            if(K > j-i+1){
                j++;
            }
            else if( K == j-i+1){
                if(queue.size()==0){
                    arr[a]=0;
                }else{
                    arr[a]= queue.peek();
                }
                a++;

                // sliding the window and removing the head of queue if A[i] is -ve
                if(A[i]<0){
                    queue.remove(A[i]);
                }
                i++;
                j++;
            }
        }
        return arr;
    }
}

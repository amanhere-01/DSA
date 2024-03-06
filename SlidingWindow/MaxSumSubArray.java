//  https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

package SlidingWindow;

import java.util.ArrayList;

public class MaxSumSubArray {

    static long maximumSumSubarray2(int K, ArrayList<Integer> Arr,int N){
        int i=0 , j=0;
        long sum=0;
        long maxSum=0;

        while (j<N){
            sum += Arr.get(j);
            if(K > j-i+1){      // j-i+1 is window size
                j++;
            }
            else if( j-i+1 == K){
                maxSum= Math.max(maxSum, sum);
                sum= sum- Arr.get(i);
                i++;
                j++;
            }
        }
        return maxSum;
    }

    
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        int c=0;
        long sum=0;

        while (c<K){
            sum+= Arr.get(c);
            c++;
        }
        long maxSum=sum;
        for(int i=1; i<=N-K ; i++){
            sum= sum - Arr.get(i-1) + Arr.get(i+K-1);
            maxSum= Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

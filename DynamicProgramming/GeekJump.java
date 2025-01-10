//https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geek-jump

import java.util.Arrays;

public class GeekJump {
    public int minimumEnergy(int arr[],int N){
        int[] dp = new int[N];
        Arrays.fill(dp, -1); 
        return rec(N - 1, dp, arr);
    }
    
    int rec(int index, int[] dp, int[] arr){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        
        int left = rec(index - 1, dp, arr)  + Math.abs(arr[index] - arr[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = rec(index - 2, dp, arr) + Math.abs(arr[index] - arr[index - 2]);
        }
        
        
        return dp[index] = Math.min(left,right);
    }
}

//https://www.geeksforgeeks.org/problems/minimal-cost/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimal-cost

public class FrogJumpKStep {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];

        for(int i=1; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    int e = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    min= Math.min(min, e);
                }
                
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}

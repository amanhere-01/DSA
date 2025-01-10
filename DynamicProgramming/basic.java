import java.util.Arrays;

public class basic {
    // TOP-DOWN approach/memoization
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibDp(n,dp);
    }

    int fibDp(int n, int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1) return dp[n];

        return dp[n] = fibDp(n-1, dp) + fibDp(n-2, dp);
    }

    // Bottom-Up approach/tabulated/iteration
    public int fib2(int n) {
        if(n<=1){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;        
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // space optimization of above
    public int fib3(int n) {
        if(n<=1){
            return n;
        }

        int prev2=0, prev=1, curr=0;      
        for(int i=2; i<=n; i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}

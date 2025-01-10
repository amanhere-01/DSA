//  https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1


public class Knapsack01 {
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        
        int[][] dp = new int[n][capacity+1];
      
        for(int i=0; i<n; i++){
            for(int j=0; j<capacity+1; j++){
                dp[i][j] = -1;
            }
        }
        return f(n-1,capacity,capacity,val,wt,dp);
    }
    
    static int f(int index, int weight,int capacity, int val[], int wt[], int[][] dp ){
        
        if(index==0){
            return wt[0] <=weight ? val[0] : 0;
        }
        
        if(dp[index][weight]!=-1) return dp[index][weight];
        
        int notPick = f(index-1, weight, capacity, val, wt, dp);
        int pick = 0;
        if(weight>=wt[index]){
            pick = val[index] + f(index-1, weight-wt[index], capacity, val, wt, dp);
        }
        
        return dp[index][weight] = Math.max(notPick, pick);
    }

      // Tabulation
    static int knapSack2(int capacity, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        
        // base case
        for(int j=wt[0]; j<=capacity; j++){
            dp[0][j] = val[0];
        }
        
        
        for(int index=1; index<n; index++){
            for(int W=0; W<=capacity; W++){
                int notPick =dp[index-1][W];
                int pick = Integer.MIN_VALUE;
                if(W>=wt[index]){
                    pick = val[index] + dp[index-1][W-wt[index]];
                }
                
                dp[index][W] = Math.max(notPick, pick);
            }
        }
        return dp[n-1][capacity];
    }
}

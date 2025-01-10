// https://www.geeksforgeeks.org/problems/chocolates-pickup/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=chocolates-pickup

import java.util.Arrays;

public class ChoclatePickup {
    public int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        for (int row1[][] : dp) {
          for (int row2[] : row1) {
            Arrays.fill(row2, -1);
          }
        }
        return f(0,0,m-1,n,m,dp,grid);
    }
    
    int f(int i, int c1, int c2, int n, int m, int[][][] dp, int[][] arr){
        if(c1<0 || c2<0 || c1>=m || c2>=m) return (int) -1e8;
        
        if(i==n-1){
            if(c1==c2) return arr[i][c1];
            else  return arr[i][c1] + arr[i][c2];
        }
        
        if(dp[i][c1][c2]!=-1) return dp[i][c1][c2];
        
        int max = Integer.MIN_VALUE;
        for(int dc1 = -1; dc1<=1; dc1++){
            for(int dc2 = -1; dc2<=1; dc2++){
                int value;
                if(c1==c2){
                    value = arr[i][c1] + f(i+1,c1+dc1,c2+dc2,n,m,dp,arr);
                } else {
                    value = arr[i][c1] + arr[i][c2] + f(i+1,c1+dc1,c2+dc2,n,m,dp,arr);
                }
                max = Math.max(max,value);
                
            }
        }
        return dp[i][c1][c2] = max;
        
    }
}

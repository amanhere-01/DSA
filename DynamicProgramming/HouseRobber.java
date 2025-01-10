//https://leetcode.com/problems/house-robber/
import java.util.Arrays;


public class HouseRobber {
    
// Memoization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return f(n-1,dp,nums);
    }

    int f(int index, int[] dp, int[] nums){
        if(index==0) return nums[0];
        if(index<1) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick = nums[index] + f(index-2, dp, nums);
        int notPick = f(index-1, dp, nums);

        return dp[index] = Math.max(pick,notPick);
    }
}


// Tabulation
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n==1) return nums[0];

//         int[] dp = new int[n];
//         dp[0] = nums[0];

//         for(int i=1; i<n; i++){
//             int pick = nums[i] ;
//             if(i-2>=0) pick += dp[i-2]; 

//             int notPick = dp[i-1];

//             dp[i] = Math.max(pick,notPick);
//         }
//         return dp[n-1];
//     }
// }

// Tabulation with Space Optimization
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int prev = nums[0];
//         int prev2 = 0;

//         for(int i=1; i<n; i++){
//             int pick = nums[i] ;
//             if(i-2>=0) pick += prev2; 
//             int notPick = prev;
            
//             prev2=prev;
//             prev = Math.max(pick,notPick);
//         }
//         return prev;
//     }
// }

// O(n2) solution
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,-1);
        
//         dp[0] = nums[0];
//         if(n==1) return nums[0];
//         if(n>1) dp[1] = nums[1];

//         for(int i=0; i<n-2; i++){
//             for(int j=i+2; j<n; j++){
//                 int sum = dp[i] + nums[j];
//                 dp[j] = Math.max(dp[j], sum);
//             }
//         }

//         return Math.max(dp[n-2], dp[n-1]);
//     }
// }
}

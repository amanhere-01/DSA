public class GeeksTraining {

    // Memoization
    public int maximumPoints(int arr[][], int N) {
        int[][] dp = new int[N][4];
        return f(N-1,3,dp,arr);   // 3 is the task which is nothing and including it total tasks gets upto 4
    }
    
    int f(int day, int last, int[][] dp, int arr[][]){
        //base case
        if(day==0){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i!=last){
                    max = Math.max(max,arr[0][i]);
                }
            }
            return max;
        }
        
        if(dp[day][last]!=0) return dp[day][last];
        
        int max=0;
        for(int i=0; i<3; i++){
            if(i!=last){
                int point = arr[day][i] + f(day-1,i, dp, arr);
                max = Math.max(max, point);
            }
        }
        dp[day][last] = max;
        return max;
    }

    // Tabulation
    public int maximumPoints2(int arr[][], int N) {
        int[][] dp = new int[N][4];
       
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); 
        
        for(int day=1; day<N; day++){
            
            for(int next=0; next<4; next++){
                int max=0;
                for(int task=0; task<3; task++){
                    if(next!=task){
                        int point = arr[day][task] + dp[day-1][task];
                        dp[day][next] = Math.max(dp[day][next], point);
                    }
                }
            }
            
        }
        
        return dp[N-1][3];
    }

    // Tabulation with Space Optimization
    public int maximumPoints3(int arr[][], int N) {
        int[] prev = new int[4];
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); 
        
        for(int day=1; day<N; day++){
            int[] temp = new int[4];
            for(int next=0; next<4; next++){
                for(int task=0; task<3; task++){
                    if(next!=task){
                        int point = arr[day][task] + prev[task];
                        temp[next] = Math.max(temp[next], point);
                    }
                }
            }
            prev = temp;
        }
        
        return prev[3];
    }
}

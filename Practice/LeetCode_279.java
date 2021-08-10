class Solution {
    public int numSquares(int n) {
        if(n <= 0){
            return 0;
        }
        
        if(n <= 3){
            return n;
        }
        
        int[] dp = new int[n+1];
        
        for (int i = 1; i * i <= n; i++) {
            dp[i*i] = 1;
        }
        
        if(dp[n] == 1){
            return 1;
        }
        
        for (int i = 2; i <= n; i++) {
            if(dp[i] == 1){
                continue;
            }
            
            int min = i;
            for(int j = 1; i > j * j; j++) {
                min = Math.min(min, dp[j*j] + dp[i - j * j]);
				if (min == 2){
                    break;
                }
            }
            
            dp[i] = min;
        }
        
        return dp[n];
    }
} 

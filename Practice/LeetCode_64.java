class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = m - 1; i >=0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int ans1 = dp[i + 1][j];
                int ans2 = dp[i][j + 1];
                
                dp[i][j] = grid[i][j] + Math.min(ans1,ans2);
            }
        }
        
        return dp[0][0];
    }
}

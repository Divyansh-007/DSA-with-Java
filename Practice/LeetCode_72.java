class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j<= n; j++) {
                if(i==0)
                {
                    dp[i][j] = j;
                }
                else if(j==0)
                {
                    dp[i][j] = i;
                }
                else
                {
                    int ans;

                    if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        ans = dp[i - 1][j - 1];
                    }else {
                        int ans1 = dp[i - 1][j];
                        int ans2 = dp[i][j - 1];
                        int ans3 = dp[i - 1][j - 1];

                        ans = 1 + Math.min(ans1, Math.min(ans2, ans3));
                    }
                    dp[i][j] = ans;
                }
            }
        }

        return dp[m][n];
    }
}

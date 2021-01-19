public class Solution{
   public class Knapsack {
      
      // recursive solution
      public static int knapsackHelp(int W, int[] wt, int[] val, int n, int i) {
        if(i == n) {
          return 0;
        }

        if(wt[i] > W) {
          return knapsackHelp(W, wt, val, n, i + 1);
        }else {
          int ans1 = val[i] + knapsackHelp(W - wt[i], wt, val, n, i + 1);
          int ans2 = knapsackHelp(W, wt, val, n, i + 1);
          return Math.max(ans1, ans2);
        }
      }

      public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        //Your code goes here
        return knapsackHelp(maxWeight,weights,values,n,0);
      }

      // iterative DP solution
      public static int knapsackItr(int[] weights, int[] values, int n, int maxWeight) {
        int[][] dp = new int[n + 1][maxWeight + 1];

        for(int i = n - 1; i >= 0; i--) {
          for(int w = 0; w <= maxWeight; w++) {
            int ans;
            if(weights[i] <= w) {
              int ans1 = values[i] + dp[i + 1][w - weights[i]];
              int ans2 = dp[i + 1][w];
              ans = Math.max(ans1, ans2);
            }else {
              ans = dp[i + 1][w];
            }

            dp[i][w] = ans;
          }
        }

        return dp[0][maxWeight];
      }
    }
}

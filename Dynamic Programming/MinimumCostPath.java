public class Solution{

    public class MinCostPath {
      
      // recursive solution
      public static int minCost(int[][] input, int i, int j) {
        int m = input.length;
        int n = input[0].length;

        if(i == m - 1 && j == n - 1) {
          return input[i][j];
        }

        if(i >= m || j >= n) {
          return Integer.MAX_VALUE;
        }

        int ans1 = minCost(input, i + 1, j);
        int ans2 = minCost(input, i, j + 1);
        int ans3 = minCost(input, i + 1, j + 1);

        return input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
      }
      
      
      public static int minCostPath(int[][] input) {
        //Your code goes here
        return minCost(input,0,0);
      }
      
      // memorization added to recursive solution
      public static int minCost(int[][] input,int i, int j, int[][] dp) {
        int m = input.length;
        int n = input[0].length;

        if(i == m - 1 && j == n - 1) {
          return input[i][j];
        }

        if(i >= m || j >= n) {
          return Integer.MAX_VALUE;
        }

        int ans1;
        int ans2;
        int ans3;

        if(dp[i + 1][j] == Integer.MIN_VALUE) {
          ans1 = minCost(input, i + 1, j, dp);
          dp[i + 1][j] = ans1;
        }else {
          ans1 = dp[i + 1][j];
        }

        if(dp[i][j + 1] == Integer.MIN_VALUE) {
          ans2 = minCost(input, i, j + 1, dp);
          dp[i][j + 1] = ans2;
        }else {
          ans2 = dp[i][j + 1];
        }

        if(dp[i + 1][j + 1] == Integer.MIN_VALUE) {
          ans3 = minCost(input, i + 1, j + 1, dp);
          dp[i + 1][j + 1] = ans3;
        }else {
          ans3 = dp[i + 1][j + 1];
        }

        return input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
      }

      public static int minCostPath(int[][] input, int[][] dp) {
        //Your code goes here
        return minCost(input,0,0,dp);
      }

      // iterative DP solution
      public static int minCostPathItr(int[][] input) {
        int m = input.length;
        int n = input[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < dp.length; i++) {
          for(int j = 0; j < dp[0].length; j++) {
            dp[i][j] = Integer.MAX_VALUE;
          }
        }

        for(int i = m - 1; i >= 0; i--) {
          for(int j = n - 1; j >= 0; j--) {
            if(i == m - 1 && j == n - 1) {
              dp[i][j] = input[i][j];
              continue;
            }
            int ans1 = dp[i + 1][j];
            int ans2 = dp[i][j + 1];
            int ans3 = dp[i + 1][j  + 1];

            dp[i][j] = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
          }
        }

        return dp[0][0];
      }

      public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] arr = {{3, 4, 1, 2},{2, 1, 8, 9},{4, 7, 8, 1}};
    //		System.out.println(minCostPath(arr));						recursive approach
    //		int[][] dp = new int[arr.length + 1][arr[0].length + 1];    rec + dp approach
    //		for(int i = 0; i < dp.length; i++) {
    //			for(int j = 0; j < dp[0].length; j++) {
    //				dp[i][j] = Integer.MIN_VALUE;
    //			}
    //		}
    //		System.out.println(minCostPath(arr,dp));
        System.out.println(minCostPathItr(arr));  				 // iterative dp appraoch

      }

    }
}

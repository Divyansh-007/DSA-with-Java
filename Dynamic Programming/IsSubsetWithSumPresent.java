public class Solution{
    public class SubsetSum {

      // reucursive solution
      public static boolean isSubsetPresentHelp(int[] arr, int n, int sum, int i) {
        if(i == n) {
          if(sum == 0) {
            return true;
          }else {
            return false;
          }
        }

        return isSubsetPresentHelp(arr, n, sum, i + 1) || isSubsetPresentHelp(arr, n, sum - arr[i], i + 1);
      }

      public static boolean isSubsetPresent(int[] arr, int n, int sum) {
        return isSubsetPresentHelp(arr, n, sum, 0);
        }

      // iterative DP solution
      public static boolean isSubsetPresentItr(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for(int j = 0; j < dp[0].length; j++) {
          dp[0][j] = false;
        }

        for(int i = 0; i < dp.length; i++) {
          dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
          for(int j = 1; j <= sum; j++) {
            dp[i][j] = dp[i - 1][j];
            if(j >= arr[i - 1]) {
              dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
            }
          }
        }

        return dp[n][sum];
      }

      public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {4,2,5,6,7};
        System.out.println(isSubsetPresent(arr, arr.length, 14));

      }

    }
}

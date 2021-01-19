public class Solution{

    public class MinmSqRepresentation {
      
      // recursive solution
      public static int minSquares(int n) {
        if(n == 0) {
          return 0;
        }

        int minAns = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++) {
          int currAns = minSquares(n - (i * i));

          if(minAns > currAns) {
            minAns = currAns;
          }
        }

        return minAns + 1;
      }

      // memorization added to recursive solution
      public static int minSquares(int n, int[] dp) {
        if(n == 0) {
          return 0;
        }

        int minAns = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++) {
          int currAns;
          if(dp[n -(i * i)] == -1) {
            currAns = minSquares(n -(i * i), dp);
            dp[n -(i * i)] = currAns;
          }else {
            currAns = dp[n -(i * i)];
          }

          if(minAns > currAns) {
            minAns = currAns;
          }
        }

        return minAns + 1;
      }

      // iterative DP solution
      public static int minSquaresItr(int n) {
        if(n == 0) {
          return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
          int minAns = Integer.MAX_VALUE;
          for(int j = 1; j*j <= i; j++) {
            int currAns = dp[i - (j * j)];

            if(minAns > currAns) {
              minAns = currAns;
            }
          }

          dp[i] = minAns + 1;
        }

        return dp[n];
      }

      public static void main(String[] args) {
        // TODO Auto-generated method stub
    //		System.out.println(minSquares(41));            recursive approach
    //		Scanner s = new Scanner(System.in);            recc + dp approach
    //		int n = s.nextInt();
    //		int[] dp = new int[n + 1];
    //		
    //		for(int i = 0; i < dp.length; i++) {
    //			dp[i] = -1;
    //		}
    //		
    //		System.out.println(minSquares(n,dp));
        System.out.println(minSquaresItr(25));       // iterative dp appraoch

      }

    }
}

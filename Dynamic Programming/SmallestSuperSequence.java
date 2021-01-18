public class solution{
    public class SuperSeqSmallest {
      
      // recursive solution
      public static int smallestSuperSequence(String str1, String str2, int i, int j) {
        if(i == str1.length() && j == str2.length()) {
          return 0;
        }else if(i == str1.length() && j != str2.length()) {
          return str2.length() - j;
        }else if(j == str2.length() && i != str1.length()) {
          return str1.length() - i;
        }

        if(str1.charAt(i) == str2.charAt(j)) {
          return 1 + smallestSuperSequence(str1, str2, i + 1, j + 1);
        }else {
          int ans1 = smallestSuperSequence(str1, str2, i + 1, j);
          int ans2 = smallestSuperSequence(str1, str2, i, j + 1);
          return 1 + Math.min(ans1, ans2);
        }
      }
      
      
      public static int smallestSuperSequence(String str1, String str2) {
        return smallestSuperSequence(str1, str2, 0, 0);
      }


      // memorization added to recursive solution
      public static int smallestSuperSequence(String str1, String str2, int[][] dp, int i, int j) {
        if(i == str1.length() && j == str2.length()) {
          return 0;
        }else if(i == str1.length() && j != str2.length()) {
          return str2.length() - j;
        }else if(j == str2.length() && i != str1.length()) {
          return str1.length() - i;
        }

        if(str1.charAt(i) == str2.charAt(j)) {
          int ans;
          if(dp[i + 1][j + 1] == -1) {
            ans = smallestSuperSequence(str1, str2, dp, i + 1, j + 1);
            dp[i + 1][j + 1] = ans;
          }else {
            ans = dp[i + 1][j + 1];
          }

          return 1 + ans;
        }else {
          int ans1;
          int ans2;

          if(dp[i + 1][j] == -1) {
            ans1 = smallestSuperSequence(str1, str2, dp, i + 1, j);
            dp[i + 1][j] = ans1;
          }else {
            ans1 = dp[i + 1][j];
          }

          if(dp[i][j + 1] == -1) {
            ans2 = smallestSuperSequence(str1, str2, dp, i, j + 1);
            dp[i][j + 1] = ans2;
          }else {
            ans2 = dp[i][j + 1];
          }

          return 1 + Math.min(ans1, ans2);
        }
      }

      public static int smallestSuperSequence(String str1, String str2, int[][] dp) {
        return smallestSuperSequence(str1, str2, dp, 0 ,0);
      }
      
      //iterative DP solution
      public static int smallestSuperSequenceItr(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];

        for(int i = dp.length; i >= 0; i--) {
          for(int j = dp[0].length; j >= 0; j--) {

            int ans;
            if(i == str1.length() && j == str2.length()) {
              ans = 0;
            }else if(i == str1.length() && j != str2.length()) {
              ans = str2.length() - j;
            }else if(j == str2.length() && i != str1.length()) {
              ans = str1.length() - i;
            }

            if(str1.charAt(i) == str2.charAt(j)) {
              ans = 1 + dp[i + 1][j + 1];
            }else {
              int ans1 = dp[i + 1][j];
              int ans2 = dp[i][j + 1];
              ans = 1 + Math.min(ans1, ans2);
            }

            dp[i][j] = ans;
          }
        }

        return dp[0][0];
      }


      public static void main(String[] args) {
        // TODO Auto-generated method stub
    //		String str1 = "pqqrpt";
    //		String str2 = "qerepct";
    //		String str1 = "ab";
    //		String str2 = "ac";
        String str1 = "abc";
        String str2 = "fac";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++) {
          for(int j = 0; j < dp[0].length; j++) {
            dp[i][j] = -1;
          }
        }
    //		System.out.println(smallestSuperSequence("pqqrpt", "qerepct"));
        System.out.println(smallestSuperSequence(str1, str2,dp));
    //		System.out.println(smallestSuperSequenceItr(str1, str2));

      }

    }
}

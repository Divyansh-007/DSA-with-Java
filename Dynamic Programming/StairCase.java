package DP1;

import java.util.Scanner;

public class StairCase {
	
	public static long staircase(int n) {
		//Your code goes here
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		if(n == 3) {
			return 4;
		}
		
		return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
	}
	
	public static long staircase(int n, long[] dp) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		if(n == 3) {
			return 4;
		}
		
		long ans1;
		long ans2;
		long ans3;
		
		if(dp[n - 1] == -1) {
			ans1 = staircase(n - 1, dp);
			dp[n - 1] = ans1;
		}else {
			ans1 = dp[n - 1];
		}
		
		if(dp[n - 2] == -1) {
			ans2 = staircase(n - 2, dp);
			dp[n - 2] = ans2;
		}else {
			ans2 = dp[n - 2];
		}
		
		if(dp[n - 3] == -1) {
			ans3 = staircase(n - 3, dp);
			dp[n - 3] = ans3;
		}else {
			ans3 = dp[n - 3];
		}
		
		return ans1 + ans2 + ans3;
	}
	
	public static long staircaseItr(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		if(n == 3) {
			return 4;
		}
		
		long[] dp = new long[n + 1];
		dp[1] = 1; 
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= n; i++) {
			dp[i] = dp[i -1] + dp[i - 2] + dp[i - 3];
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
//		System.out.println(staircase(4));                  recursive method
//		Scanner s = new Scanner(System.in);                recur + dp approach
//		int n = s.nextInt();
//		long[] dp = new long[n + 1];
//		for(int i = 0; i < dp.length; i++) {
//			dp[i] = -1;
//		}
//		System.out.println(staircase(n,dp));
		System.out.println(staircaseItr(10));             // iterative dp approach
	}
}

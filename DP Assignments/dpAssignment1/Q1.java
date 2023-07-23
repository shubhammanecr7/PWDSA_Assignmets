package dpAssignment1;

public class Q1 {
	/*
	 * ref leetcode 70 Q1. There are n stairs, a person standing at the bottom wants
	 * to reach the top. The person can climb either 1,2,3...m stairs at a time
	 * where m is a user given integer. Count the number of ways the person can
	 * reach the top.
	 * 
	 * input : n=5,m=3 output : 7
	 */

	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		int ways = countWays(n, m);
		System.out.println("Number of ways : " + ways);
	}

	private static int countWays(int n, int m) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m && j <= i; j++) {
				dp[i] = dp[i] + dp[i - j];
			}
		}
		return dp[n-1];
	}
}
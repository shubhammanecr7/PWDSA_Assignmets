package dpAssignment1;

public class Q4 {
	/*
	 * leetcode 62 There is a robot on an m x n grid. The robot is initially located
	 * at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
	 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
	 * either down or right at any point in time.
	 * 
	 * Given the two integers m and n, return the number of possible unique paths
	 * that the robot can take to reach the bottom-right corner.
	 * 
	 * The test cases are generated so that the answer will be less than or equal to
	 * 2 * 109.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * 
	 * Input: m = 3, n = 7 Output: 28 Example 2:
	 * 
	 * Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there
	 * are a total of 3 ways to reach the bottom-right corner: 1. Right -> Down ->
	 * Down 2. Down -> Down -> Right 3. Down -> Right -> Down
	 */

	public static void main(String[] args) {
		int m = 3, n = 2;
		int result = uniquePaths(m, n);
		System.out.println(result);
	}

	private static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		// make each first row element 1
		for (int i = 0; i < n; i++)
			dp[0][i] = 1;
		// make each first column element 1
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// ..... // top element + right element
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}

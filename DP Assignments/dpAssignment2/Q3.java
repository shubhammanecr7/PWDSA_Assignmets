package dpAssignment2;

public class Q3 {
	/*
	 * leetcode 64 Given a m x n grid filled with non-negative numbers, find a path
	 * from top left to bottom right, which minimizes the sum of all numbers along
	 * its path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * 
	 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]] Output: 7 Explanation: Because the
	 * path 1 → 3 → 1 → 1 → 1 minimizes the sum. Example 2:
	 * 
	 * Input: grid = [[1,2,3],[4,5,6]] Output: 12
	 */

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int path = minPath(grid);
		System.out.println(path);
	}

	private static int minPath(int[][] grid) {
		// TODO Auto-generated method stub
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		// adding first element
		dp[0][0] = grid[0][0];
		// first we fill out the values for first row and column
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i]; // dp current = dp prev + grid current
		}
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[m - 1][n-1];
	}
}

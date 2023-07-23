package dpAssignment2;

public class Q1 {
	/*
	 * leetcode 63 You are given an m x n integer array grid. There is a robot
	 * initially located at the top-left corner (i.e., grid[0][0]). The robot tries
	 * to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can
	 * only move either down or right at any point in time.
	 * 
	 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
	 * the robot takes cannot include any square that is an obstacle.
	 * 
	 * Return the number of possible unique paths that the robot can take to reach
	 * the bottom-right corner.
	 * 
	 * The testcases are generated so that the answer will be less than or equal to
	 * 2 * 109. Example 1: Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]] Output: 2
	 * Explanation: There is one obstacle in the middle of the 3x3 grid above. There
	 * are two ways to reach the bottom-right corner: 1. Right -> Right -> Down ->
	 * Down 2. Down -> Down -> Right -> Right Example 2: Input: obstacleGrid =
	 * [[0,1],[0,0]] Output: 1
	 */

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		int path = uniquePathWithObstacles(obstacleGrid);
		System.out.println(path);
	}

	private static int uniquePathWithObstacles(int[][] obstacleGrid) {
		// TODO Auto-generated method stub
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;

		// if first element is blocked
		if (obstacleGrid[0][0] == 1)
			return 0;

		int[][] dp = new int[row][col];

		// make first row and col elements as 1 and skip if any obstacle cell comes
		for (int j = 0; j < col; j++) {
			if (obstacleGrid[0][j] == 0)
				dp[0][j] = 1;
			else
				break;
		}

		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 0)
				dp[i][0] = 1;
			else
				break;
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[row - 1][col - 1];
	}
}
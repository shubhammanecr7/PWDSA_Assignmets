package dpAssignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5 {
	/*
	 * leetcode 120. Given a triangle array, return the minimum path sum from top to
	 * bottom.
	 * For each step, you may move to an adjacent number of the row below. More
	 * formally, if you are on index i on the current row, you may move to either
	 * index i or index i + 1 on the next row. Example 1:
	 * 
	 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] Output: 11 Explanation: The
	 * triangle looks like: 2 3 4 6 5 7 4 1 8 3 The minimum path sum from top to
	 * bottom is 2 + 3 + 5 + 1 = 11 (underlined above). Example 2:
	 * 
	 * Input: triangle = [[-10]] Output: -10
	 */

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		int result = minimumTotal(triangle);
		System.out.println(result);
	}

	private static int minimumTotal(List<List<Integer>> triangle) {
		// base case
		if (triangle == null || triangle.isEmpty())
			return 0;

		int rows = triangle.size();

		// array to store minimum path of each cell
		int[][] dp = new int[rows][rows];

		// last row of triangle will have same minimum path
		// so we put last row as it is to dp array
		List<Integer> lastRow = triangle.get(rows - 1);
		for (int i = 0; i < rows; i++) {
			dp[rows - 1][i] = lastRow.get(i);
		}

		// bottopm up dp approach : now we start from second last row
		// here i = row and j = column
		for (int i = rows - 2; i >= 0; i--) {
			List<Integer> currentRow = triangle.get(i);
			for (int j = 0; j < currentRow.size(); j++) {
				// now we add = current col element + min ( bottom j or j+1 )element
				// i+1 used to go to respective bottom row j & j+1 to select min appropriate
				// element
				dp[i][j] = currentRow.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
			}
		}

		// minimum sum will be stored at the top of dp array [0][0]
		return dp[0][0];
	}
}
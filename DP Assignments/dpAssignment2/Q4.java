package dpAssignment2;

public class Q4 {
	/*
	 * leetcode 416 Given an integer array nums, return true if you can partition
	 * the array into two subsets such that the sum of the elements in both subsets
	 * is equal or false otherwise.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,5,11,5] Output: true Explanation: The array can be
	 * partitioned as [1, 5, 5] and [11]. Example 2:
	 * 
	 * Input: nums = [1,2,3,5] Output: false Explanation: The array cannot be
	 * partitioned into equal sum subsets.
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };
		boolean result = canPartition(nums);
		System.out.println(result);
	}

	private static boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		// If the total sum is odd, it is not possible to partition into two equal
		// subsets
		if (totalSum % 2 != 0) {
			return false;
		}

		int targetSum = totalSum / 2;
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][targetSum + 1];

		// Base case: If the target sum is 0, it is always possible with an empty subset
		// filling first col 
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= targetSum; j++) {
				if (j < nums[i - 1]) {
					// If the current element is greater than the current target sum,
					// we cannot include it in the subset, so we copy the result from the previous
					// row.
					dp[i][j] = dp[i - 1][j];
				} else {
					// Otherwise, we have two choices:
					// 1. Include the current element in the subset and check if the remaining sum
					// is possible with the remaining elements.
					// 2. Exclude the current element from the subset and check if the sum is
					// possible with the remaining elements.
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}

		// The last cell dp[n][targetSum] will have the answer.
		return dp[n][targetSum];
	}
}

package priorityQueueAssignment;

import java.util.Arrays;
import java.util.PriorityQueue;

/*Q4. You are given an m x n matrix mat that has its rows sorted in non-decreasing order 
 * and an integer k.
You are allowed to choose exactly one element from each row to form an array.
Return the kth smallest array sum among all possible arrays.
Example 1:
Input: mat = [[1,3,11],[2,4,6]], k = 5
Output: 7
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
Example 2:
Input: mat = [[1,3,11],[2,4,6]], k = 9
Output: 17
Example 3:
Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
Output: 9
Explanation: Choosing one element from each row, the first k smallest sum are:
[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.*/
public class Q4 {
	public static void main(String[] args) {
		int[][] mat = { { 1, 3, 11 }, { 2, 4, 6 } };
		int k = 5;
		int kthSmallestSum = kthSmallest(mat, k);
		System.out.println("Kth Smallest Array Sum: " + kthSmallestSum);
	}

	private static int kthSmallest(int[][] mat, int k) {
		int m = mat.length;
		int n = mat[0].length;

		// Create a min heap (priority queue) to store the sums
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// Add the first element from each row to the min heap along with their sum
		for (int i = 0; i < m; i++) {
			minHeap.offer(mat[i][0]);
		}

		// While the kth smallest sum has not been found and the min heap is not empty
		while (k > 1 && !minHeap.isEmpty()) {
			int sum = minHeap.poll();

			// For each row, if there is a next element available
			for (int i = 0; i < m; i++) {
				if (n > 1 && mat[i][0] == sum) {
					// Calculate the sum by adding the next element to the previously removed sum
					int newSum = sum + mat[i][1];
					minHeap.offer(newSum);
					// Move to the next element in the row
					mat[i] = Arrays.copyOfRange(mat[i], 1, n);
				}
			}
			k--;
		}
		return minHeap.peek();
	}
}

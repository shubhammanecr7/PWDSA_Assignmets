package heapAssignment;

import java.util.PriorityQueue;

/*Q2. Given n ropes of different lengths, connect them into a single rope with minimum cost. 
 * Assume that the cost to connect two ropes is the same as the sum of their lengths.
For example,
Input: [5, 4, 2, 8]
Output: The minimum cost is 36
[5, 4, 2, 8] –> First, connect ropes of lengths 4 and 2 that will cost 6.
[5, 6, 8] –> Next, connect ropes of lengths 5 and 6 that will cost 11.
[11, 8] –> Finally, connect the remaining two ropes that will cost 19.
Therefore, the total cost for connecting all ropes is 6 + 11 + 19 = 36.*/
public class Q2 {
	public static void main(String[] args) {
		int[] ropes = { 5, 4, 2, 8 };
		int minimumCost = findMinimumCost(ropes);
		System.out.println("The minimum cost is " + minimumCost);
	}

	private static int findMinimumCost(int[] ropes) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// Insert all the rope lengths into the min heap
		for (int length : ropes) {
			minHeap.offer(length);
		}

		int totalCost = 0;

		while (minHeap.size() > 1) {
			// Extract the two smallest lengths from the min heap
			int first = minHeap.poll();
			int second = minHeap.poll();

			// Merge the two lengths and add the merged length back to the min heap
			int mergedLength = first + second;
			minHeap.offer(mergedLength);

			// Update the total cost
			totalCost += mergedLength;
		}

		return totalCost;
	}
}

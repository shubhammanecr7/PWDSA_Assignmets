package heapAssignment;

import java.util.PriorityQueue;

/*Q4. You are given an array of integer stones where stones[i] is the weight of the ith stone. We are playing a
game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose
the heaviest two stones have weights x and y with x <= y. The result of this smash is:
If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.
Return the weight of the last remaining stone. If there are no stones left, return 0.
Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:
Input: stones = [1]
Output: 1*/
public class Q4 {
	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		int result = lastStoneWeight(stones);
		System.out.println("Output 1: " + result);
	}

	private static int lastStoneWeight(int[] stones) {
		// Create a max heap (priority queue) to store the weights of the stones
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		// Insert all the stone weights into the max heap
		for (int weight : stones) {
			maxHeap.offer(weight);
		}

		// Smash the stones until there is at most one stone left
		while (maxHeap.size() > 1) {
			int heaviest1 = maxHeap.poll(); // Extract the first heaviest stone
			int heaviest2 = maxHeap.poll(); // Extract the second heaviest stone

			if (heaviest1 != heaviest2) {
				int difference = Math.abs(heaviest1 - heaviest2);
				maxHeap.offer(difference); // Insert the difference back into the max heap
			}
		}

		// Check if there is one stone remaining or no stones left
		if (maxHeap.isEmpty()) {
			return 0;
		} else {
			return maxHeap.peek(); // Return the weight of the last remaining stone
		}
	}
}
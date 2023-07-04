package priorityQueueAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*Q2. You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second
array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: 
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: 
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]*/
public class Q2 {
	public static void main(String[] args) {
		int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);
        System.out.println("Output : " + result);
	}

	private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();

        // Create a min heap (priority queue) to store the pairs along with their sums
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));

        // Add pairs (u, v) with sums to the min heap
        for (int u : nums1) {
            for (int v : nums2) {
                minHeap.offer(new int[]{u, v});
            }
        }

        // Remove the pair with the smallest sum until the min heap has k elements
        while (k > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            result.add(Arrays.asList(pair[0], pair[1]));
            k--;
        }

        return result;
	}
}

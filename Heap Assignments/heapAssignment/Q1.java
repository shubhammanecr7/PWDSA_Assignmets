package heapAssignment;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*Q1. Given an integer array, find the kth largest element using priority queue.
Input 1 : arr[] = {1,2,3,5,2,6,9} k = 3
Output 1: 5
Input 2 : arr[] = {1,7,8,5,2,6,9} k = 6
Output 2: 2*/
public class Q1 {
	// Function to find the k'th largest element in an array using max-heap
	public static int findKthLargest(List<Integer> ints, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
														// or pass `Comparator.reverseOrder()`
		pq.addAll(ints);

		// pop from max-heap exactly `k-1` times
		while (--k > 0) {
			pq.poll();
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1,2,3,5,2,6,9);
		int k = 3;
		System.out.println("k'th largest array element is " + findKthLargest(ints, k));
	}
}
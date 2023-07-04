package heapAssignment;

import java.util.PriorityQueue;

/*Q1. Given an integer array, find the kth largest element using priority queue.
Input 1 : arr[] = {1,2,3,5,2,6,9} k = 3
Output 1: 5
Input 2 : arr[] = {1,7,8,5,2,6,9} k = 6
Output 2: 2*/
public class Q1 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 2, 6, 9 };
		int k = 3;
		int result = findKthLargest(arr, k);
		System.out.println("Output 1: " + result);
	}

	private static int findKthLargest(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(); // default creation of min heap

		// here we create a heap for k elements
		for (int i = 0; i < k; i++)
			heap.add(arr[i]);

		// now we start elements to the created min heap
		// due to below iteration the kth largest element will come at root of min heap
		for (int i = k; i < arr.length; i++) {
			if (heap.peek() < arr[i]) {
				heap.poll(); // first remove the root element
				heap.add(arr[i]); // add arr[i] element to min heap
			}
		}

		// After above operations top element of the heap is the kth largest element
		return heap.peek();
	}
}
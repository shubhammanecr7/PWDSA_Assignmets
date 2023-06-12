package divideAndConquerAssignment;

import java.util.Arrays;

import divideAndConquerClass.MergeSort;

/*Q1. Given an array where all its elements are sorted in increasing order except two swapped
elements, sort it in linear time. Assume there are no duplicates in the array.
input : arr[] = [3, 8, 6, 7, 5, 9, 10]
output : arr[] = [3, 5, 6, 7, 8, 9, 10]*/

public class Q1 {
	public static void main(String[] args) {
		int arr[] = { 3, 8, 6, 7, 5, 9, 10 };
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(int[] arr) {
		int n = arr.length;
		int[] result = mergeSort(arr, 0, n - 1);
		for (int i = 0; i < n; i++)
			arr[i] = result[i];
	}

	private static int[] mergeSort(int[] arr, int low, int high) {
		// Base case- If subarray has only one element return it
		if (low == high) {
			int[] basecase = { arr[low] };
			return basecase;
		}

		// divide subarray into two halfs
		int mid = (low + high) / 2;
		int[] left = mergeSort(arr, low, mid); // sort left half
		int[] right = mergeSort(arr, mid + 1, high); // sort right half
		int[] merged = merge(left, right); // merger both halfs
		return merged;
	}

	private static int[] merge(int[] left, int[] right) {
		int m = left.length;
		int n = right.length;
		int[] merged = new int[m + n];
		int i = 0, j = 0, k = 0;

		// Merge the two sorted subarrays into one
		while (i < m && j < n) {
			if (left[i] <= right[j]) {
				merged[k] = left[i];
				i++;
			} else {
				merged[k] = right[j];
				j++;
			}
			k++;
		}

		// copying remaining elements from left subarray
		while (i < m)
			merged[k++] = left[i++];

		// copying remaining elements from right subarray
		while (j < n)
			merged[k++] = right[j++];

		return merged;
	}
}
package divideAndConquerAssignment;

import java.util.Arrays;

/*Q3. Given an array of positive and negative integers, segregate them in linear time and constant
space. The output should print all negative numbers, followed by all positive numbers. The
relative order of elements must remain the same.
i/p : arr[] = {19, -20, 7, -4, -13, 11, -5, 3}
o/p : arr[] = {-20 ,-4, -13, -5, 19 ,7 ,11, 3}*/
public class Q3 {
	public static void main(String[] args) {
		int arr[] = { 19, -20, 7, -4, -13, 11, -5, 3 };
		divideAndConquer(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void divideAndConquer(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;

			// divide array into two halfs
			divideAndConquer(arr, low, mid);
			divideAndConquer(arr, mid + 1, high);

			// merge sorted halfs
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;

		// temporary arrays to store elements
		int[] left = new int[n1];
		int[] right = new int[n2];

		// copyelements from original arrays to temporary arrays
		for (int i = 0; i < n1; i++)
			left[i] = arr[low + i];

		for (int i = 0; i < n2; i++)
			right[i] = arr[mid + 1 + i];

		int i = 0, j = 0, k = low;

		// merge negative elementrs from left sub-array
		while (i < n1 && left[i] < 0)
			arr[k++] = left[i++];

		// merge negative elements from right sub-array
		while (j < n2 && right[j] < 0)
			arr[k++] = right[j++];

		// merge positive elements from left sub-array
		while (i < n1 && left[i] > 0)
			arr[k++] = left[i++];

		// merge positive elements from right sub-array
		while (j < n2 && right[j] > 0)
			arr[k++] = right[j++];
	}

}

package quickSelectAlgorithmAssignment;

/*Q1. Given an integer array, find the kth largest element using the 
 quickselect algorithm.
Input : arr[] = {1,3,2,4,5,6,7} , k = 3
Output : 5

Input : arr[] = {4,3,3,2,1} , k = 4
Output : 2
*/
public class Q1 {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 4, 5, 6, 7 };
		int k = 3;
		int result = findKthLargest(arr, k, 0, arr.length - 1);
		System.out.println(result);
	}

	private static int findKthLargest(int[] arr, int k, int low, int high) {
		int pivot = getPivot(arr, low, high);
		if (pivot == k - 1)
			return arr[pivot];
		else if (pivot < k - 1)
			return findKthLargest(arr, k, pivot + 1, high);
		else
			return findKthLargest(arr, k, low, pivot - 1);
	}

	private static int getPivot(int[] arr, int low, int high) {
		// choose middle element as pivot
		int mid = low + (high - low) / 2;
		int pivotElement = arr[mid];
		int pivot = low;

		for (int i = low; i <= high; i++) {
			if (arr[i] > pivotElement) {
				int temp = arr[i];
				arr[i] = arr[pivot];
				arr[pivot] = temp;
				pivot++;
			}
		}
		int temp = arr[pivot];
		arr[pivot] = arr[mid];
		arr[mid] = temp;

		return pivot;
	}
}

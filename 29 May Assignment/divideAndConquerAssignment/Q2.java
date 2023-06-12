package divideAndConquerAssignment;

import java.util.Arrays;

/*Q2. Given an array of positive and negative integers, segregate them in 
 * linear time and constant space. The output should print all negative 
 * numbers, followed by all positive numbers.
 * (segregate means seperate)
i/p : arr[] = {19, -20, 7, -4, -13, 11, -5, 3}
o/p : arr[] = {-20 ,-4, -13, -5, 19 ,11 ,3, 7}*/
public class Q2 {
	public static void main(String[] args) {
		int arr[] = { 19, -20, 7, -4, -13, 11, -5, 3 };
		segregateNegativePositive(arr);
		System.out.println(Arrays.toString(arr));
	}

	//function to print negative numbers before positive numbers
	private static void segregateNegativePositive(int[] arr) {
		int left = 0; // leftmost pointer
		int right = arr.length - 1; // rightmost pointer

		while (left <= right) {

			// move left pointer untill we reach positive number
			while (left <= right && arr[left] < 0)
				left++;

			// move right pointer untill we reach negative number
			while (left <= right && arr[right] > 0)
				right--;

			// swap positive number at left with negative at right
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	}
}

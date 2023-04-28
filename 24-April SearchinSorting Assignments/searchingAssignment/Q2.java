package searchingAssignment;

import java.util.Scanner;

/*Q2. Given an array and an integer “target”, return the last occurrence of “target” in the array. If the target is
not present return -1.
Input 1: arr = [1 1 1 2 3 4 4 5 6 6 6 6] , target = 4
Output 1: 6
Input 2: arr = [2 2 2 6 6 18 29 30 30 30] , target = 15
Output 2: -1*/
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = sc.nextInt();
		int[] a = new int[size];
		System.out.println("Enter elements :");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("Enter searching element :");
		int target = sc.nextInt(); sc.close();
		int result = findLastOccurance(a, target);
		if (result == -1)
			System.out.println("Element not found in array");
		else
			System.out.println("Last occurance at index : " + result);

	}

	private static int findLastOccurance(int[] a, int target) {
		int result = -1, low = 0, high = a.length - 1;
		while(low<=high)
		{
			int mid = low + (high-low)/2;
			if (a[mid] == target) {
				result = mid;
				low = mid+1;
			}else if (a[mid] > target) {
				high = mid -1;
			}else {
				low = mid+1;
			}
		}
		return result;
	}
}
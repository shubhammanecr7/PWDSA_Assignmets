package sortingAssignment;

import java.util.Arrays;

//WAP to sort an array in decending order using selection sort
public class Q2 {
	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 6, 0 };
		doSelectionSort(a);
		System.out.println("Sorted array in decending order : ");
		System.out.println(Arrays.toString(a));
	}

	private static void doSelectionSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[maxIndex]) {
					maxIndex = j;
				}
			}

			if (maxIndex != i) {
				int temp = a[maxIndex];
				a[maxIndex] = a[i];
				a[i] = temp;
			}
		}
	}
}
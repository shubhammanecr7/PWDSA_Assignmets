package sortingAssignment;

import java.util.Arrays;

//WAP to sort an array in decreasing order using insertion sort
public class Q3 {
	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 6, 0 };
		System.out.println("Sorted array decreasing order : ");
		doInsertionSort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void doInsertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j=i;
			while (j>0 && a[j] > a[j-1]) {
				int temp = a[j];
				a[j]=a[j-1];
				a[j-1]=temp;
				j--;
			}
		}
	}
}

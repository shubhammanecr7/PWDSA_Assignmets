package sortingAssignment;

import java.util.Arrays;

//Write a program to sort an array in descending order using bubble sort.
public class Q1 {
	public static void main(String[] args) {
		int a[] = {3,5,1,6,0};
		doBubbleSort(a);
		System.out.println("Sorted array in decending order :");
		System.out.println(Arrays.toString(a));
	}

	private static void doBubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j]<a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					isSwapped=true;
				}
			}
			if (!isSwapped) {
				break;
			}
		}
	}
}
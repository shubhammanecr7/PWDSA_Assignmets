package searchingAssignment;

/*Q3. Given a sorted binary array, efficiently count the total number of 1’s in it.*/
import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = sc.nextInt();
		int[] a = new int[size];
		System.out.println("Enter elements :");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int result = countOnes(a);
		if (result == -1)
			System.out.println("Element not found in array");
		else
			System.out.println("Element occured : " + result + " times");

	}

	private static int countOnes(int[] a) {
		int low = 0, high = a.length - 1, mid = 0, firstOccurance = -1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (a[mid] == 1) {
				firstOccurance = mid;
				high = mid - 1;
			}else if(a[mid] == 0) {
				low = mid +1;
			}
		}
		if(firstOccurance == -1) {
			return -1;
		}
		//total occurance = array length - firstOccurance index
		return a.length-firstOccurance;
	}
}
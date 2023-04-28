package searchingAssignment;
/*Given a sorted integer array containing duplicates, count occurrences of a given number. If the element
is not found in the array, report that as well.*/
import java.util.*;
public class Q4 {
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
		int result = countOccurance(a, target);
		if (result == 0)
			System.out.println("Element not found in array");
		else
			System.out.println("Element occurance time : " + result);

	}

	private static int countOccurance(int[] a, int target) {
		int cnt =0;
		for (int element : a) {
			if(element == target)
				cnt++;
		}
		return cnt;
	}
}

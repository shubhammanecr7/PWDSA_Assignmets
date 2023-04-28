package searchingAssignment;
import java.util.Scanner;

/*Q1. Given an array. FInd the number X in the array. If the element is present, return the index of the element,
else print “Element not found in array”. Input the size of array, array from user and the element X from user.
Use Linear Search to find the element.*/
public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = sc.nextInt();
		int []a = new int[size];
		System.out.println("Enter elements :");
		for (int i = 0; i < a.length; i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("Enter searching element :");
		int target = sc.nextInt(); sc.close();
		int result = doLinearSearch(a,target);
		if(result == -1)
			System.out.println("Element not found in array");
		else
			System.out.println("Found at index : "+result);
	}
	//finding index of element using linear search
	private static int doLinearSearch(int[] a, int target) {
		int result = -1;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==target)
				result=i;
		}
		return result;
	}
}

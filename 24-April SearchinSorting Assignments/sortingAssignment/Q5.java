package sortingAssignment;

/*Find out the number of iterations to sort the array in descending order using selection sort.*/
public class Q5 {
	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 6, 0 };
		System.out.println("No of passes required to sort :");
		int result = doSelectionSort(a);
		System.out.println(result);
	}

	private static int doSelectionSort(int[] a) {
		int passes = 0;
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
			passes++;
		}
		return passes;
	}
	
}
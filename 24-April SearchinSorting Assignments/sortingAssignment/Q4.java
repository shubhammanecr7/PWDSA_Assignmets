package sortingAssignment;

/*Find out how many pass would be required to sort the following array in decreasing order
using bubble sort*/
public class Q4 {
	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 6, 0 };
		System.out.println("No of passes required to sort :");
		int result = doBubbleSort(a);
		System.out.println(result);
	}

	private static int doBubbleSort(int[] a) {
		int passes = 0;
		for (int i = 0; i < a.length-1; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					isSwapped=true;
				}
			}
			passes++;
			if (!isSwapped) {
				break;
			}
		}
		return passes;
	}
}

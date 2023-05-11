package recursionAssignment;

/*Print the max value of the array [ 13, 1, -3, 22, 5].*/
public class Q3 {
	public static void main(String[] args) {
		int a[] = { 13, 1, -3, 22, 5 };
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		System.out.println("Max Value = " + max);
	}
}
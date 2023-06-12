package divideAndConquerAssignment;

import java.util.Arrays;

/*Q4. Given two arrays of equal size n and an integer k. The task is to permute both arrays such
that the sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The
task is to print “Yes” if any such permutation exists, otherwise print “No”.
i/p : a[] = {2, 1, 3},
b[] = { 7, 8, 9 },
k = 10.
o/p : Yes

i/p : a[] = {1, 2, 2, 1},
b[] = { 3, 3, 3, 4 },
k = 5.
o/p : No*/
public class Q4 {
	public static void main(String[] args) {
		int a[] = { 2, 1, 3 };
		int b[] = { 7, 8, 9 };
		int k = 10;

		String result = checkPermutation(a, b, k);
		System.out.println(result);
	}

	private static String checkPermutation(int[] a, int[] b, int k) {
		int n = a.length - 1;
		// sort both array
		Arrays.sort(a);
		Arrays.sort(b);

		// check for permutation who satisfy the condition
		for (int i = 0; i < n; i++) {
			if (a[i] + b[n - i] < k) {
				return "No";
			}
		}
		return "Yes";
	}
}

package greedyAssignment;

/*Q1. Find the minimum sum of Products of two arrays of the same size, given that k modifications
are allowed on the first array. In each modification, one array element of the first array can either
be increased or decreased by 2.
Examples:
i/p : a[] = {1, 2, -3}
	  b[] = {-2, 3, -5}
	  k = 5
o/p : -31,
i/p : a[] = {2, 3, 4, 5, 4}
	  b[] = {3, 4, 2, 3, 2}
	  k = 3
o/p : 25*/
public class Q1 {
	public static void main(String[] args) {
		int a[] = { 1, 2, -3 };
		int b[] = { -2, 3, -5 };
		int k = 5;

		int result = minimumSumOfProducts(a, b, k);
		System.out.println(result);
	}

	private static int minimumSumOfProducts(int[] a, int[] b, int k) {
		int diff = 0, res = 0;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			int pro = a[i] * b[i];
			res = res + pro;
			if (pro < 0 && b[i] < 0)
				temp = (a[i] + 2 * k) * b[i];
			else if (pro < 0 && a[i] < 0)
				temp = (a[i] - 2 * k) * b[i];
			else if (pro > 0 && a[i] < 0)
				temp = (a[i] + 2 * k) * b[i];
			else if (pro > 0 && a[i] > 0)
				temp = (a[i] - 2 * k) * b[i];

			int d = Math.abs(pro - temp);
			if (d > diff)
				diff = d;
		}
		return res - diff;
	}
}

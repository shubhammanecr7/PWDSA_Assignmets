package stackAssignment;

import java.util.Stack;

/*Q1. Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing
only 1's and return its area.*/
public class Q1LargestRectangle {

	public static void main(String[] args) {
		int a[][] = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };

		int largestRectangle = findLargestRectangle(a);
		System.out.println(largestRectangle);
	}

	private static int findLargestRectangle(int[][] a) {
		int currentRow[] = a[0];
		int maxAns = findHistogram(currentRow);
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1)
					currentRow[j]++;
				else
					currentRow[j] = 0;
			}
			int currentAns = findHistogram(currentRow);
			maxAns = Math.max(maxAns, currentAns);
		}
		return maxAns;
	}

	private static int findHistogram(int[] a) {
		int maxArea = 0;
		int ps[] = findPreviousSmaller(a);
		int ns[] = findNextSmaller(a);
		for (int i = 0; i < a.length; i++) {
			int currentMax = (ns[i] - ps[i] - 1) * a[i];
			maxArea = Math.max(maxArea, currentMax);
		}
		return maxArea;
	}

	private static int[] findNextSmaller(int[] a) {
		Stack<Integer> s = new Stack<>();
		int ns[] = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			while (!s.isEmpty() && a[s.peek()] >= a[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				ns[i] = a.length;
			} else {
				ns[i] = s.peek();
			}
			s.push(i);
		}
		return ns;
	}

	private static int[] findPreviousSmaller(int[] a) {
		int ps[] = new int[a.length];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			while (!s.isEmpty() && a[s.peek()] >= a[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				ps[i] = -1;
			} else {
				ps[i] = s.peek();
			}
			s.push(i);
		}
		return ps;
	}
}
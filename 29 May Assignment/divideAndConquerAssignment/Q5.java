package divideAndConquerAssignment;

import java.util.Arrays;

/*Q5. An interval is represented as a combination of start time and end time. Given a set of
intervals, check if any two intervals intersect.
i/p : arr[] = {{1, 3}, {5, 7}, {2, 4}, {6, 8}}
o/p : Yes . The intervals {1, 3} and {2, 4} overlap
*/
public class Q5 {
	public static void main(String[] args) {
		int arr[][] = { { 1, 3 }, { 5, 7 }, { 2, 4 }, { 6, 8 } };

		String resultString = checkIntervalsIntersection(arr) ? "Yes" : "No ";
		System.out.println(resultString);
	}

	private static boolean checkIntervalsIntersection(int[][] arr) {

		// first sort the array based on start index
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		
		//loop to check intersection
		for(int i=0 ; i<arr.length ; i++) {
			if (arr[i][1] >= arr[i+1][0]) {
				return true;
			}
		}
		return false;
	}
}
package greedyAssignment;

/*Q2. You are given n activities with their start and finish times. Select the maximum number of
activities that can be performed by a single person, assuming that a person can only work on a
single activity at a time.
Examples:
i/p : start[] = {10, 12, 20}, finish[] = {20, 25, 30}
o/p : 0 2
i/p : start[] = {1, 3, 0, 5, 8, 5}, finish[] = {2, 4, 6, 7, 9, 9};
o/p : 0 1 3 4*/
public class Q2 {
	// Prints a maximum set of activities that can be done by a single person, one
	// at a time.
	public static void printMaxActivities(int s[], int f[], int n) {
		int i, j;

		System.out.println("These activities are selected : ");

		i = 0;
		System.out.print(i + " ");

		// Consider rest of the activities
		for (j = 1; j < n; j++) {
			// If this activity has start time greater than or equal to the finish time of
			// previously selected activity, then select it
			if (s[j] >= f[i]) {
				System.out.print(j + " ");
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int finish[] = { 3, 5, 6, 8, 9, 9 };
		int n = start.length;
		printMaxActivities(start, finish, n);
	}
}

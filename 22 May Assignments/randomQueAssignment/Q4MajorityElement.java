package randomQueAssignment;

/*Q4. Given an array nums of size n, return the majority element.
Input: 4,2,7,1,9
Output: 9*/
public class Q4MajorityElement {
	public static void main(String[] args) {
		int[] nums = { 4, 2, 7, 1, 9 };
		int majorityElement = findMajorityElement(nums);
		System.out.println("Majority Element: " + majorityElement);
	}

	// function to find majority element
	private static int findMajorityElement(int[] nums) {
		int count = 0;
		int element = 0;
		for (int num : nums) {
			if (count == 0) {
				element = num;
				count++;
			} else if (num == element) {
				count++;
			} else {
				count--;
			}
		}
		return element;
	}
}

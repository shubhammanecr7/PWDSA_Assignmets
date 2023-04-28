package numberSystemAssignment;

/*Q5. Given an integer array, duplicates are present in it in a way that all duplicates appear an even
number of times except one which appears an odd number of times. Find that odd appearing
element in linear time and without using any extra memory.
For example,
Input : arr[] = [4, 3, 6, 2, 6, 4, 2, 3, 4, 3, 3]
Output : The odd occurring element is 4.*/
public class Q5 {
	public static void main(String[] args) {
		int a[] = {4, 3, 6, 2, 6, 4, 2, 3, 4, 3, 3};
		//approach  (only works if only one odd duplicate occurance)
		for (int i = 0; i < a.length; i++) {
			int count=0;
			for (int j = 0; j < a.length; j++) {
				if (a[i]==a[j]) {
					count++;
				}
			}
			if(count%2!=0) {
				System.out.println("Odd occuring element :"+a[i]); break;
			}
		}
		
		
	}
}
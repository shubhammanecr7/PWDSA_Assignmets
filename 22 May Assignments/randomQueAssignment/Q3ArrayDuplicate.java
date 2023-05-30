package randomQueAssignment;

import java.util.HashSet;
import java.util.Set;

/*Q3.Detect if an Array contains a duplicate element. 
 * At Most 1 duplicate would be there.
Input: 1,2,3,4
Output: No
Input: 1, 2, 3, 4, 1
Output: Yes.*/
public class Q3ArrayDuplicate {
	public static void main(String[] args) {
		int a1[] = { 1, 2, 3, 4 };
		int a2[] = { 1, 2, 3, 4, 1 };
		
		boolean hasDuplicate1 = checkDuplicates(a1);
		boolean hasDuplicate2 = checkDuplicates(a2);
		
		System.out.println("for a1 : "+(hasDuplicate1? "Yes":"No"));
		System.out.println("for a2 : "+(hasDuplicate2? "Yes":"No"));
	}

	private static boolean checkDuplicates(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int element : a) {
			if (set.contains(element)) {
				return true;  //if duplicate found
			}
			set.add(element);
		}
		return false; //if no dulpicates
	}
}

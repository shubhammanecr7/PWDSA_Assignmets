package randomQueAssignment;

/*Q5. Given two strings ransomNote and magazine, return true if ransomNote can be
 *  constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Input: ransomNote = "a", magazine = "b"
Output: false
Input: ransomNote = "aa", magazine = "ab"
Output: false*/
public class Q5StringRansomeNote {
	public static void main(String[] args) {
		String ransoneNote = "aa";
		String magzine = "aab";

		boolean result = canConstruct(ransoneNote, magzine);
		System.out.println(result);
	}

	private static boolean canConstruct(String ransoneNote, String magzine) {
		int a[] = new int[26];
		// getting all characters
		for (char ch : magzine.toCharArray()) {
			a[ch - 'a']++;
		}

		// finding possibility to create note
		for (char ch : ransoneNote.toCharArray()) {
			if (a[ch - 'a'] == 0) {
				return false;
			}
			a[ch - 'a']--;
		}
		return true;
	}
}

package stackAssignment;

import java.util.Stack;

/*Q2. Given an encoded string, return its decoded string. The encoding rule is: k[encoded_string],
where the encoded_string inside the square brackets is being repeated exactly k times. Note
that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square
brackets are well-formed, etc. Furthermore, you may assume that the original data does not
contain any digits and that digits are only for those repeat numbers, k. For example, there will
not be input like 3a or 2[4].
Example 1:
input : s = "3[a]2[bc]"
output : "aaabcbc"*/
public class Q2EncodedString {
	public static void main(String[] args) {
		String encodedString = "3[a]2[bc]";
		// function calling
		String decodedString = decodeString(encodedString);
		System.out.println(decodedString);
	}

	private static String decodeString(String encodedString) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		String decodedString = "";
		int count = 0;
		for (char c : encodedString.toCharArray()) {
			if (Character.isDigit(c)) {
				count = count * 10 + (c - '0');
			} 
			else if (c == '[') {
				countStack.push(count);
				stringStack.push(decodedString);
				count = 0;
				decodedString = "";
			}
			else if (c==']') {
				StringBuilder sb = new StringBuilder(stringStack.pop());
				int repeatCount = countStack.pop();
				for(int i=0;i<repeatCount;i++) {
					sb.append(decodedString);
				}
				decodedString = sb.toString();
			}
			else {
				decodedString += c;
			}
		}
		return decodedString;
	}
}

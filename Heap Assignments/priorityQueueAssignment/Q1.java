package priorityQueueAssignment;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*Q1. Given a string s, rearrange the characters of s so that any two adjacent characters are not 
 * the same.
Return any possible rearrangement of s or return "" if not possible.
Example 1:
Input: s = "aab"
Output: "aba"
Example 2:
Input: s = "aaab"
Output: ""*/
public class Q1 {
	public static void main(String[] args) {
		String s = "aab";
		System.out.println("Output " + rearrangeString(s));
	}

	public static String rearrangeString(String s) {
		// Create a character frequency map
		Map<Character, Integer> charFrequency = new HashMap<>();
		for (char c : s.toCharArray()) {
			charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
		}

		// Create a priority queue (min heap) to store characters based on frequency
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
			if (charFrequency.get(a).equals(charFrequency.get(b))) {
				return a.compareTo(b); // Sort by lexicographical order if frequencies are equal
			}
			return charFrequency.get(a) - charFrequency.get(b); // Sort by frequency
		});

		// Add characters to the priority queue
		pq.addAll(charFrequency.keySet());

		// Build the rearranged string
		StringBuilder rearranged = new StringBuilder();
		
		while (pq.size() > 1) {
			char first = pq.poll();
			char second = pq.poll();

			rearranged.append(first);
			rearranged.append(second);

			charFrequency.put(first, charFrequency.get(first) - 1);
			charFrequency.put(second, charFrequency.get(second) - 1);

			if (charFrequency.get(first) > 0) {
				pq.offer(first);
			}
			if (charFrequency.get(second) > 0) {
				pq.offer(second);
			}
		}

		if (!pq.isEmpty()) {
			char last = pq.poll();
			rearranged.append(last);
			charFrequency.put(last, charFrequency.get(last) - 1);
		}

		if (rearranged.length() == s.length()) {
			return rearranged.toString();
		} else {
			return "";
		}
	}
}

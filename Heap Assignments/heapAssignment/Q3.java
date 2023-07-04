package heapAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*Q3. Given an array of string ‘words’ and an integer k, return the k most frequent strings. 
 * Return the answer
sorted by the frequency from highest to lowest. Sort the words with the same frequency by their
lexicographical order.
Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number 
of occurrences
being 4, 3, 2 and 1 respectively.*/
public class Q3 {
	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;
		List<String> result = findKMostFrequentWords(words, k);
		System.out.println("Output : " + result);
	}

	public static List<String> findKMostFrequentWords(String[] words, int k) {
		// Count the occurrences of each word
		Map<String, Integer> wordCount = new HashMap<>();
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		System.out.println(wordCount);

		// Create a priority queue with custom comparator to sort the words by frequency
		// and lexicographical order
		PriorityQueue<WordFreq> pq = new PriorityQueue<>((a, b) -> {
			if (a.frequency == b.frequency) {
				return b.word.compareTo(a.word); // Sort by lexicographical order if frequencies are equal
			}
			return a.frequency - b.frequency; // Sort by frequency
		});

		// Iterate through the word counts map and add them to the priority queue
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			// add each word and its frequency as WordFreq Object
			pq.offer(new WordFreq(entry.getKey(), entry.getValue()));
			if (pq.size() > k) {
				pq.poll(); // Remove the word with the lowest frequency if the queue size exceeds k
			}
		}

		// Create a result list by retrieving the k most frequent words from the priority queue
		List<String> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			result.add(0, pq.poll().word); 
			// Add words to the front of the list to maintain the desired order
		}
		return result;
	}
}
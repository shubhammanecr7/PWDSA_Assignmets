package randomQueAssignment;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*Q1. Implement a Map in java which takes the input and print the list in sorted
 *  order based on key.*/
public class Q1KeyBasedSorting {
	public static void main(String[] args) {
		// Create a TreeMap
		TreeMap<String, Integer> map = new TreeMap<>();

		// Take input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		for (int i = 0; i < n; i++) {
			System.out.print("Enter key: ");
			String key = scanner.nextLine();
			System.out.print("Enter value: ");
			int value = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			// Add key-value pair to the TreeMap
			map.put(key, value);
		}
		scanner.close();
		// Print the sorted list based on keys
		System.out.println("Sorted list:");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}
}

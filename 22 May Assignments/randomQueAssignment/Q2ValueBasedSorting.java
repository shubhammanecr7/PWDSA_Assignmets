package randomQueAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Q2. Implement a Map in java which takes the input and print the list in sorted
 *  order based on value.
Input: 5- Rahul, 7 Lakshman, 1 Ram, 4 Krrish, 2 Lakshay
Output: {Krish=4,Lakshay=2,Lakshman=7,Rahul=5,Ram=1}*/
public class Q2ValueBasedSorting {
	public static void main(String[] args) {
		// creation of map
		Map<Integer, String> empIdNameMap = new HashMap<>();
		empIdNameMap.put(1, "Shyam");
		empIdNameMap.put(2, "Atul");
		empIdNameMap.put(3, "Bharat");
		empIdNameMap.put(4, "Deva");

		// original map printing using lambda expression
		System.out.println("Original Map : ");
		empIdNameMap.forEach((k, v) -> System.out.println(k + "  " + v));

		Set<Entry<Integer, String>> entrySet = empIdNameMap.entrySet();

		// creation of list for sorting using comparator
		List<Entry<Integer, String>> list = new ArrayList<>(entrySet);

		Collections.sort(list, new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
				// TODO Auto-generated method stub
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		System.out.println("Value Based SortedMap : ");
		list.forEach(e -> System.out.println(e.getKey() + "  " + e.getValue()));
	}
}

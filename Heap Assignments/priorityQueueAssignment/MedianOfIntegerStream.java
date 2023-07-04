package priorityQueueAssignment;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*Q5. Given that integers are read from a data stream. Find the median of elements read 
so for in an efficient way.  For simplicity assume, there are no duplicates. 
For example, let us consider the streams 5, 15, 1, 3 ...
After reading 1st element of stream - 5 -> median - 5
After reading 2nd element of stream - 5, 15 -> median - 10
After reading 3rd element of stream - 5, 15, 1 -> median - 5
After reading the 4th element of stream - 5, 15, 1, 3 -> median - 4, so on.*/
public class MedianOfIntegerStream {
	private static Queue<Integer> minHeap, maxHeap;

	static void add(int num) {
		if (!minHeap.isEmpty() && num < minHeap.peek()) {
			maxHeap.offer(num);
			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}
		} else {
			minHeap.offer(num);
			if (minHeap.size() > maxHeap.size() + 1) {
				maxHeap.offer(minHeap.poll());
			}
		}
	}

	static double getMedian() {
		int median;
		if (minHeap.size() < maxHeap.size()) {
			median = maxHeap.peek();
		} else if (minHeap.size() > maxHeap.size()) {
			median = minHeap.peek();
		} else {
			median = (minHeap.peek() + maxHeap.peek()) / 2;
		}
		return median;
	}

	static void initialize() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		MedianOfIntegerStream obj = new MedianOfIntegerStream();

		obj.add(3);
		System.out.println("The median is : " + getMedian());
		obj.add(3);
		obj.add(2);
		obj.add(5);
		System.out.println("The median is : " + getMedian());
		obj.add(7);
		obj.add(12);
		System.out.println("The median is : " + getMedian());
	}

	public static void main(String[] args) {
		initialize();
	}
}

package stackAssignment;

import java.util.Stack;

/*Given an array of integers temperatures represents the daily temperatures, return an array
answer such that answer[i] is the number of days you have to wait after the ith day to get a
warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0
instead.
Example 1:
input : temperatures = [73,74,75,71,69,72,76,73]
output : [1,1,4,2,1,1,0,0]*/
public class Q5TemperatureArray {
	public static void main(String[] args) {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] answer = dailyTemperatures(temperatures);

		System.out.print("output: [");
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
			if (i != answer.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	private static int[] dailyTemperatures(int[] temperatures) {
		int[] answer = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>(); // Stores indices of temperatures

		for (int i = 0; i < temperatures.length; i++) {
			// Check if current temperature is higher than the temperatures in the stack
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int prevIndex = stack.pop();
				answer[prevIndex] = i - prevIndex;
			}

			stack.push(i);
		}

		return answer;
	}
}

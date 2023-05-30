package stackAssignment;

import java.util.Stack;

/*Q4. We are given an array of asteroids of integers representing asteroids in a row.For each
asteroid, the absolute value represents its size, and the sign represents its direction (positive
meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will
explode. If both are the same size, both will explode. Two asteroids moving in the same direction
will never meet.
Example 1:
input : asteroids = [5,10,-5]
output : [5,10]*/
public class Q4AsteroidsOfIntegers {
	public static void main(String[] args) {
		int[] asteroids = { 5, 10, -5 };
		int[] result = asteroidCollision(asteroids);

		System.out.print("Output: [");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i != result.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	private static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
					stack.pop();
				}
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				} else if (stack.peek() == Math.abs(asteroid)) {
					stack.pop();
				}
			}
		}

		int[] result = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return result;
	}
}

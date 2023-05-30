package stackAssignment;

import java.util.Stack;

/*Q3. You are keeping the scores for a baseball game with strange rules. At the beginning of the
game, you start with an empty record. You are given a list of strings operations, where operations[i] is the ith operation you must apply
to the record and is one of the following:
An integer x. Record a new score of x.
'+'. Record a new score that is the sum of the previous two scores.
'D'. Record a new score that is the double of the previous score.
'C'. Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.
input: ops = ["5","2","C","D","+"]
output: 30*/
public class Q3BaseBallGame {
	public static void main(String[] args) {
		String[] ops = { "5", "2", "C", "D", "+" };
		int scoreSum = calculateScoreSum(ops);
		System.out.println(scoreSum);
	}

	private static int calculateScoreSum(String[] ops) {
		Stack<Integer> stack = new Stack<>();

		for (String op : ops) {
			if (op.equals("C")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (op.equals("D")) {
				if (!stack.isEmpty()) {
					int prevScore = stack.peek();
					stack.push(prevScore * 2);
				}
			} else if (op.equals("+")) {
				if (stack.size() >= 2) {
					int prevScore1 = stack.pop();
					int prevScore2 = stack.peek();
					stack.push(prevScore1);
					stack.push(prevScore1 + prevScore2);
				}
			} else {
				int score = Integer.parseInt(op);
				stack.push(score);
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		return sum;
	}
}

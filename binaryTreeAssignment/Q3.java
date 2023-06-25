package binaryTreeAssignment;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*Q3. Given the root of a binary tree, return the reverse level order traversal of its nodes' values. The
solution should consider the binary tree nodes level by level in bottom-up order from left to right,
i.e., process all nodes of the last level first, followed by all nodes of the second last level, and so on.*/
public class Q3 {
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		reverseLevelOrderTraversal(root);
	}

	private static void reverseLevelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		// create an empty queue and add the root node
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		// create a stack to reverse level order nodes
		Deque<Integer> stack = new ArrayDeque<>();

		// to store the current node
		Node curr;

		// loop till queue is empty
		while (!queue.isEmpty()) {
			// process each node in the queue and enqueue their children
			curr = queue.poll();

			// push the current node into the stack
			stack.push(curr.data);

			// it is important to process the right node before the left node
			if (curr.right != null) {
				queue.add(curr.right);
			}

			if (curr.left != null) {
				queue.add(curr.left);
			}
		}

		// pop all nodes from the stack and print them
		while (!stack.isEmpty()) {
			System.out.print(stack.poll() + " ");
		}
	}
}

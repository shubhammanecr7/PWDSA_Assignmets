package binaryTreeAssignment;

import java.util.ArrayDeque;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Queue;

/*Q2. Given the root of a binary tree, check if it is a complete binary tree or not. A complete binary
tree is a binary tree in which every level, except possibly the last, is filled, and all nodes are as far
left as possible.*/
public class Q2 {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		if (isComplete(root))
			System.out.println("Complete binary tree");
		else
			System.out.println("Not a complete binary tree");
	}

	private static boolean isComplete(Node root) {
		// return if the tree is empty
		if (root == null)
			return true;

		// create an emopty queue and add root to it
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		// to store current node
		Node current;
		// flag to mark the end of full nodes
		boolean flag = false;

		// loop till queue is empty
		while (!q.isEmpty()) {
			// remove front node
			current = q.poll();

			// if we have encountered a non-full node before and the current node
			// is not a leaf, a tree cannot be complete
			if (flag && (current.left != null || current.right != null)) {
				return false;
			}

			// if the left child is empty and the right child exists,
			// a tree cannot be complete
			if (current.left == null && current.right != null) {
				return false;
			}

			// if the left child exists, enqueue it
			if (current.left != null) {
				q.add(current.left);
			}
			// if the current node is a non-full node, set the flag to true
			else {
				flag = true;
			}

			// if the right child exists, enqueue it
			if (current.right != null) {
				q.add(current.right);
			}
			// if the current node is a non-full node, set the flag to true
			else {
				flag = true;
			}
		}
		return true;
	}
}

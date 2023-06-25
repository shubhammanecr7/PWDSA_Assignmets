package binaryTreeAssignment;

import java.util.HashMap;
import java.util.Map;

/*Q4. Given the root of a binary tree, return the left view of its nodes' values. Assume the left and
right child of a node makes a 45–degree angle with the parent.*/
public class Q4 {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		leftView(root);
	}

	// Function to print the left view of a given binary tree
	private static void leftView(Node root) {
		// create an empty HashMap to store the first node for each level
		Map<Integer, Integer> map = new HashMap<>();

		// traverse the tree and fill the map
		leftView(root, 1, map);

		// iterate through the HashMap in sorted order of its keys
		// and print the left view
		for (int i = 1; i <= map.size(); i++) {
			System.out.print(map.get(i) + " ");
		}
	}

	// Recursive function to traverse the nodes in a preorder fashion
	private static void leftView(Node root, int level, Map<Integer, Integer> map) {
		// base case
		if (root == null) {
			return;
		}

		// if the level is visited for the first time, insert the current node
		// and level information into the map
		map.putIfAbsent(level, root.data);

		leftView(root.left, level + 1, map);
		leftView(root.right, level + 1, map);
	}

}

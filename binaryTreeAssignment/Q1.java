package binaryTreeAssignment;

/*Q1. Given the root of a binary tree, return the spiral level order traversal of its nodes' values. The
solution should consider the binary tree nodes level by level in spiral order, i.e., all nodes present
at level 1 should be processed first from left to right, followed by nodes of level 2 from right to left,
followed by nodes of level 3 from left to right and so on... In other words, odd levels should be
processed from left to right, and even levels should be processed from right to left.*/
public class Q1 {
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		doSpiralOrderTraversal(root);
	}

	private static void doSpiralOrderTraversal(Node root) {
		if (root == null)
			return;
		// start from level 1 — till the height of the tree
		int level = 1;

		// run till one of the function returns false
		while (printLevelLeftToRight(root, level++) && printLevelRightToLeft(root, level++))
			;

	}

	// function to print all nodes of given level from left to right
	private static boolean printLevelLeftToRight(Node root, int level) {
		if (root == null)
			return false;

		if (level == 1) {
			System.out.print(root.data + " ");
			return true;
		}

		// goto left child before right child
		boolean left = printLevelLeftToRight(root.left, level - 1);
		boolean right = printLevelLeftToRight(root.right, level - 1);

		return left || right;
	}

	// function to print all nodes of given level from right to left
	private static boolean printLevelRightToLeft(Node root, int level) {
		if (root == null)
			return false;

		if (level == 1) {
			System.out.print(root.data + " ");
			return true;
		}

		// goto right child before left child
		boolean right = printLevelRightToLeft(root.right, level - 1);
		boolean left = printLevelRightToLeft(root.left, level - 1);
		return right || left;
	}
}
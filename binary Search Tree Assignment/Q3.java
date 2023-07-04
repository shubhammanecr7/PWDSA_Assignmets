package binarySearchTreeAssignment;

/*Q3. Given a binary search tree, find a pair with a given sum present in it.
For example, consider the following BST. If the given sum is 14, the pair is (8, 6).*/

public class Q3 {

	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);

		root.left.left = new Node(8);
		root.left.right = new Node(12);

		root.right.left = new Node(20);
		root.right.right = new Node(30);

		root.left.left.left = new Node(6);
		root.left.left.right = new Node(9);

		root.right.left.left = new Node(18);
		root.right.left.right = new Node(22);

		int targetSum = 14;
		findPairWithSum(root, targetSum);
	}

	private static void findPairWithSum(Node root, int targetSum) {
		if (root == null)
			return;

		// Perform an in-order traversal and store the nodes in an array
		Node[] nodes = new Node[9];
		storeInOrder(root, nodes, 0);

		// Use two-pointer technique to find the pair with the given sum
		int left = 0;
		int right = nodes.length - 1;

		while (left < right) {
			int sum = nodes[left].data + nodes[right].data;

			if (sum == targetSum) {
				System.out.println("Pair found: (" + nodes[left].data + ", " + nodes[right].data + ")");
				return;
			}

			if (sum < targetSum)
				left++;
			else
				right--;
		}

		System.out.println("No pair found with the given sum.");

	}

	private static int storeInOrder(Node root, Node[] nodes, int index) {
		if (root == null)
			return index;

		index = storeInOrder(root.left, nodes, index);
		nodes[index++] = root;
		index = storeInOrder(root.right, nodes, index);

		return index;

	}
}

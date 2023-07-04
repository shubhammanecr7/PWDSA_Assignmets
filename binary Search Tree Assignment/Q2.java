package binarySearchTreeAssignment;

/*Q2. Given a BST and a positive number k, find the k'th largest node in the BST.
For example, consider the following binary search tree. If k = 2, the k'th largest node is 20.*/
public class Q2 {
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		int k = 2;
		Node result = findKthLargest(root, k);
		System.out.println("Kth largest : " + result.data);
	}

	static int count = 0;

	private static Node findKthLargest(Node root, int k) {
		if (root == null)
			return null;

		Node right = findKthLargest(root.right, k);
		if (right != null)
			return right;
		count++;
		if (count == k)
			return root;

		return findKthLargest(root.left, k);
	}
}

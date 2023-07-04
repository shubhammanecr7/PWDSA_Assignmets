package binarySearchTreeAssignment;

/*Q1. Write an iterative program to search for an element in BST. Also construct a sample BST and
try to search for elements in the same.
The for BST is : 15, 10, 20, 8, 12, 16, 25
Search for 25 in it.*/
public class Q1 {
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		int key = 25;
		System.out.println("Found key : " + searchBST(root, key));
	}

	private static boolean searchBST(Node root, int key) {
		// if tree empty return
		if (root == null)
			return false;
		// if key found return true
		if (root.data == key)
			return true;

		// if key value is less than current node data go left for searching
		if (key < root.data)
			return searchBST(root.left, key);
		else
			return searchBST(root.right, key);
	}
}

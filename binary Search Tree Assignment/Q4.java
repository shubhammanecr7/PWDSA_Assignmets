package binarySearchTreeAssignment;

/*Q4. Given a BST, find the inorder predecessor of a given key in it. If the key does not lie 
 * in the BST, return the previous greater node (if any) present in the BST.
The predecessor of node 15 is 12
The predecessor of node 10 is 8
The predecessor of node 20 is 16
The predecessor doesn’t exist for node 8
The predecessor of node 12 is 10
The predecessor of node 16 is 15
The predecessor of node 25 is 20
A node’s inorder predecessor is a node with maximum value in its left subtree, i.e., its left
subtree’s right-most child. If the left subtree of the node doesn’t exist, then the inorder
predecessor is one of its ancestors*/
public class Q4 {
	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		/*
		 * In the context of a binary search tree (BST), the predecessor of a node is
		 * defined as the node with the largest value that is smaller than the given
		 * node. In other words, it is the node that comes immediately before the given
		 * node in an inorder traversal of the BST.
		 */
		// lets find Predecesssor for node = 16
		Node keyNode = root.right.left;
		Node predecessor = findInorderPredecessor(root, keyNode);

		if (predecessor != null) {
			System.out.println("The predecessor of node " + keyNode.data + " is: " + predecessor.data);
		} else {
			System.out.println("The predecessor doesn't exist for node " + keyNode.data);
		}
	}

	private static Node findInorderPredecessor(Node root, Node keyNode) {
		if (root == null || keyNode == null)
			return null;

		// Case 1: If the left subtree of the keyNode exists, find the rightmost node in
		// that subtree
		if (keyNode.left != null)
			return findRightmostNode(keyNode.left);

		// Case 2: If the left subtree of the keyNode doesn't exist, find the ancestor node
		// which is the first node with a value less than the keyNode
		Node predecessor = null;
		while (root != null) {
			if (keyNode.data > root.data) {
				predecessor = root;
				root = root.right;
			} else if (keyNode.data < root.data) {
				root = root.left;
			} else {
				break;
			}
		}
		return predecessor;
	}

	public static Node findRightmostNode(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
}
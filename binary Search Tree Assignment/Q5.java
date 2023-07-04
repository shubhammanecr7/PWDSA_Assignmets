package binarySearchTreeAssignment;

/*Q5. Given a BST and two nodes x and y in it, find the lowest common ancestor (LCA) of x and y.
The solution should return null if either x or y is not the actual node in the tree.*/
public class Q5 {
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

		Node x = root.left.left; // x=8
		Node y = root.right.left.left; // y=18

		Node lca = findLowestCommonAncestor(root, x, y);
		if (lca != null) {
			System.out.println("Lowest Common Ancestor of " + x.data + " and " + y.data + " is: " + lca.data);
		} else {
			System.out.println("Either " + x.data + " or " + y.data + " is not present in the tree.");
		}
	}

	private static Node findLowestCommonAncestor(Node root, Node x, Node y) {
		if (root == null)
			return null;

		if (root == x || root == y)
			return root;

		Node leftLCA = findLowestCommonAncestor(root.left, x, y);
		Node rightLCA = findLowestCommonAncestor(root.right, x, y);

		if (leftLCA != null && rightLCA != null)
			return root;

		//if left common ancestor is not null we return left LCA otherwise we return right LCA
		return (leftLCA != null) ? leftLCA : rightLCA;
	}
}

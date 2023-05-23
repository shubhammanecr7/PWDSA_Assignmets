package linkedListClass;

/*Insert a node at the given position in a linked list. We are given a 
 * pointer to a node, and the new node is inserted after the given node.*/
class Q2LinkedList {
	Node head;

	// Function to insert a node after a given node
	void insertAfter(Node prevNode, int newData) {
		if (prevNode == null) {
			System.out.println("Previous node cannot be null.");
			return;
		}

		Node newNode = new Node(newData);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	// Function to display the linked list
	void displayList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Test the program
	public static void main(String[] args) {
		Q2LinkedList linkedList = new Q2LinkedList();

		// Create the linked list
		linkedList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(4);
		Node fourth = new Node(5);

		linkedList.head.next = second;
		second.next = third;
		third.next = fourth;

		// Insert a node after the given node (second node in this case)
		Node givenNode = second;
		int newData = 3;
		linkedList.insertAfter(givenNode, newData);

		// Display the updated linked list
		linkedList.displayList();
	}
}

package linkedListClass;

/*
 * Given two numbers represented by two lists, write a function that returns the
 * sum list. The sum list is a list representation of the addition of two input
 * numbers.
 */
class Q5LinkedList {
	Node head;

	// Function to add two numbers represented by linked lists
	Node addTwoNumbers(Node l1, Node l2) {
		Node dummy = new Node(0); // Dummy node to track the head of the sum list
		Node current = dummy;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int sum = carry;
			//we add digit by digit
			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}

			carry = sum / 10;
			sum %= 10;

			current.next = new Node(sum); // Create a new node with the sum value
			current = current.next; // Move the current pointer to the newly created node
		}

		if (carry > 0) {
			current.next = new Node(carry); // If there is a remaining carry, add it as a new node
		}

		return dummy.next; // Return the head of the sum list
	}

	// Function to display the linked list
	void displayList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Test the program
	public static void main(String[] args) {
		Q5LinkedList linkedList = new Q5LinkedList();

		// Create the first linked list
		Node l1 = new Node(2);
		l1.next = new Node(4);
		l1.next.next = new Node(3);

		// Create the second linked list
		Node l2 = new Node(5);
		l2.next = new Node(6);
		l2.next.next = new Node(4);

		// Add the two numbers and display the sum list
		Node sumList = linkedList.addTwoNumbers(l1, l2);
		linkedList.displayList(sumList);
	}
}

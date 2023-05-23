package linkedListClass;

/*Given the head of a sorted linked list, delete all duplicates such that 
each element appears only once. Return the linked list sorted as well.*/
class Q3LinkedList {
	Node head;

	// Function to delete duplicate nodes from a sorted linked list
	Node deleteDuplicates(Node head) {
		Node current = head;

		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
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
		Q3LinkedList linkedList = new Q3LinkedList();

		// Create the sorted linked list
		linkedList.head = new Node(1);
		Node second = new Node(1);
		Node third = new Node(2);
		Node fourth = new Node(3);
		Node fifth = new Node(3);

		linkedList.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		// Delete duplicate nodes and display the sorted linked list
		Node newHead = linkedList.deleteDuplicates(linkedList.head);
		linkedList.displayList(newHead);
	}
}
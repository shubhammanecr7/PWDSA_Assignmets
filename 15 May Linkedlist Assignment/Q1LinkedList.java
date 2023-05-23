package linkedListClass;

/*Given a linked list and a key ‘X‘ in, the task is to check if X is present 
 * in the linked list or not.*/

public class Q1LinkedList {
	Node head;

	// function to check if key is present or not
	public boolean isPresent(int key) {
		Node current = head;
		// traverse the list
		while (current != null) {
			if (current.data == key) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public static void main(String[] args) {

		Q1LinkedList ll = new Q1LinkedList();
		ll.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);

		ll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		int key=3;
		System.out.println(ll.isPresent(key));
	}
}

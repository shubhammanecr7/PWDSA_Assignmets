package linkedListClass;

/*Given two numbers represented by two lists, write a function that returns 
the sum list. The sum list is a list representation of the addition of two 
input numbers.*/
class Q4LinkedList {
    Node head;

    // Function to check if the linked list is a palindrome
    boolean isPalindrome() {
        if (head == null) {
            return true; // An empty list is considered a palindrome
        }

        Node slow = head;
        Node fast = head;

        // Find the middle node of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        //We send slow.next so that only post middle part is reversed
        Node secondHalf = reverse(slow.next);
        Node firstHalf = head;

        // Compare the reversed second half with the first half
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Function to reverse a linked list
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Test the program
    public static void main(String[] args) {
    	Q4LinkedList linkedList = new Q4LinkedList();

        // Create the linked list
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(1);

        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Check if the linked list is a palindrome
        boolean isPalindrome = linkedList.isPalindrome();

        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}

package CH03;

public class PrintCommonPart {
	public static class Node {
		public int value;
		public Node next;
		public Node (int data) {
			this.value = data;
		}
	}
	
	public static void printCommonPart(Node head1, Node head2) {
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			if (head1.value == head2.value) {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1.value < head2.value) {
				head1 = head1.next;
			} else {
				head2 = head2.next;
			}
		}
	}
	
	public static void printLinkedlist(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(2);
		node1.next = new Node(3);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(6);

		Node node2 = new Node(1);
		node2.next = new Node(2);
		node2.next.next = new Node(5);
		node2.next.next.next = new Node(5);
		node2.next.next.next.next = new Node(8);

		printLinkedlist(node1);
		printLinkedlist(node2);
		printCommonPart(node1, node2);

	}
}

package OJExercise;

import OJExercise.ReorderList.ListNode;

/*
 * Given a linked list, determine if it has a cycle in it.
 * if there is no cycle, return null.
 * Follow up:Can you solve it without using extra space?
 */
public class LinkedListCycle {
	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next!=null && fast.next.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast==slow) {
				return fast;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(5);
		L1.next.next.next.next.next = L1;
		System.out.println(detectCycle(L1).val);
	}
}

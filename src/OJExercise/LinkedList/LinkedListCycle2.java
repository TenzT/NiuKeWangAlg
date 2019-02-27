package OJExercise.LinkedList;

import OJExercise.LinkedList.PartitionList.ListNode;

/*
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * Follow up:Can you solve it without using extra space?
 */
public class LinkedListCycle2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast!=null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast==slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(5);
		L1.next.next.next.next.next = L1.next;
		System.out.println(detectCycle(L1).val);

		L1 = new ListNode(1);
		L1.next = new ListNode(2);
		System.out.println(detectCycle(L1).val);

	}
}

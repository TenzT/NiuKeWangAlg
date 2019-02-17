package OJExercise;

import java.util.Stack;

/*
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 */
public class ReorderList {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
			this.next = null;
		}
	}
	
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		// 获得中点后一位
		ListNode mid = getMid(head).next;
		Stack<ListNode> stack = new Stack<>();
		while(mid != null) {
			stack.push(mid);
			mid = mid.next;
		}
		// 滑动指针
		ListNode cur = head;
		while (cur!=null) {
			if(!stack.isEmpty()) {
				// 插入节点
				ListNode next = cur.next;
				cur.next = stack.pop();
				cur.next.next = next;
				cur = cur.next.next;
			} else {
				cur.next = null;
				cur = cur.next;
			}
		}
	}
	
	/*
	 * 使用快慢指针法得到链表中点
	 */
	public static ListNode getMid(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;
		while (fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	// for test
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(5);
		printList(L1);
		reorderList(L1);
		printList(L1);
	}
}

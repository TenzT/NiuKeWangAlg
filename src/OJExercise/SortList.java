package OJExercise;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 思路：常数空间的 n log n 有快排和归并，由于是链表，所以采用归并，难点在于链表实现merge,链表实现merge与数组的相似,不过需要有链表头
 * 对于链表，使用快慢指针来得到中点
 */
public class SortList {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
			this.next = null;
		}
	}
	
	public static ListNode sort(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		}
		ListNode mid = getMid(list);
		ListNode right = sort(mid.next);
		mid.next = null;
		ListNode left = sort(list);
		list = merge(left, right);
		return list;
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
	
	public static ListNode merge(ListNode L1, ListNode L2) {
		if (L2 == null) {
			return L1;
		}
		if (L1 == null) {
			return L2;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while(L1 !=null && L2 != null) {
			if(L1.val < L2.val) {
				cur.next = L1;
				L1 = L1.next;
			} else {
				cur.next = L2;
				L2 = L2.next;
			}
			cur = cur.next;
		}
			
		if (L1 == null) {
			cur.next = L2;
		}
		
		if (L2 == null) {
			cur.next = L1;
		}
		
		return dummy.next;
	}
	
	// for test
	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListNode L1 = new ListNode(-1);
		L1.next = new ListNode(5);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(0);
		printList(L1);
		ListNode res = sort(L1);
		printList(res);
		
		System.out.println();
	}
	
}

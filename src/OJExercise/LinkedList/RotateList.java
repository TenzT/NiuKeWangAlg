package OJExercise.LinkedList;

import OJExercise.LinkedList.RemoveDuplicateFromSortedList.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given1->2->3->4->5->NULLand k =2,
 * return4->5->1->2->3->NULL.
 * 思路：前后指针，前面的指针比当前指针快k步，前指针到达链表尾部时，后指针指向倒数第k-1个
 * PS:由于要考虑n超出链表长度的问题，要对链表长度取模才行
 */
public class RotateList {
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}
	public static ListNode rotateRight(ListNode head, int n) {
	      if (head == null || head.next==null) {
	    	  return head;
	      }
	      ListNode dummy = new ListNode(0);
	      ListNode front;
	      ListNode back;
	      dummy.next = head;
	      
	      int length = 0;
	      front = dummy;
	      while (front.next != null) {
	    	  front = front.next;
	    	  length++;
	      }
	      n = n % length;
	      
	      front = dummy;
	      back = dummy;
	      
	      while (front!=null && n>0) {
	    	  front = front.next;
	    	  n--;
	      }
	      
	      while (front.next!=null) {
	    	  front = front.next;
	    	  back = back.next;
	      }

	      // 反转长度就是链表长度或者n=0的情况
	      if (back.next == head || front==back) {
	    	  return head;
	      }
	      
	      front.next = dummy.next;
	      front = back.next;
	      back.next = null;
	      
	      return front;
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
		for (int i=0; i< 10; i++) {
			ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);
	        printList(head);
	        printList(rotateRight(head, i));
	        System.out.println();
		}
		ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        printList(head);
        printList(rotateRight(head, 3));
        System.out.println();
		
        
//		head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        printList(head);
//        printList(rotateRight(head, 4));
	}
}

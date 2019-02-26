package OJExercise;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given1->2->3->3->4->4->5, return1->2->5.
 * Given1->1->1->2->3, return2->3.
 */
public class RemoveDuplicateFromSortedList2 {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    //思路：首先使用dummy指针，可以搞定全部相同的情况，然后有快慢指针，快指针走在前面，一直检测有没有重复的，有则消除，没有则两个指针向前走
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast.next = fast.next.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return dummy.next;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        printList(head);
        printList(deleteDuplicates(head));

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        printList(head);
        printList(deleteDuplicates(head));
    }
}

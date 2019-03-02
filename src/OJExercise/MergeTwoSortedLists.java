package OJExercise;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            // TODO Auto-generated constructor stub
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode mergeTwoLists(ListNode L1, ListNode L2) {
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
}

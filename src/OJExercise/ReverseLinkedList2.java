package OJExercise;

public class ReverseLinkedList2 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }



    public static ListNode rereverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next==null || m==n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int index = 0;
        ListNode cur = dummy;
        ListNode preM = null;   // m点前一位
        while (cur != null && index < m-1) {
            cur = cur.next;
            index++;
        }
        preM = cur;
        ListNode next = cur.next;
        while (cur != null && index <= n-1) {
            ListNode tmp = next;
            next = next.next;
            tmp.next = cur;
            cur = tmp;
            index++;
        }

        preM.next.next = next;
        preM.next = cur;
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
        ListNode L1 = new ListNode(1);
        printList(L1);
        ListNode L2 = rereverseBetween(L1, 0, 0);
        printList(L2);
        L1 = new ListNode(1);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(3);
        L1.next.next.next = new ListNode(4);
        L1.next.next.next.next = new ListNode(5);
        L1.next.next.next.next.next = new ListNode(6);
        printList(L1);
        L2 = rereverseBetween(L1, 1, 6);
        printList(L2);
    }
}

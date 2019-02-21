package OJExercise;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * requirement: You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//    两个指针，前一个指针pre找到第一个大于等于target的节点，后一个指针一直往后扫，如果找到了小于x的节点，则在pre进行前面插入
//    public static ListNode partition(ListNode head, int x) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode pre = dummy;
//        while (pre !=null && pre.next!=null && pre.next.val<x) {
//            pre = pre.next;
//        }
//        if (pre == null || pre.next==null) {
//            return dummy.next;
//        }
//        ListNode post = pre.next;
//        while (post !=null) {
//            if (post.next != null && post.next.val < x) {
//                ListNode tmp = post.next;
//                post.next = post.next.next;
//                post = post.next;
//                tmp.next = pre.next;
//                pre.next = tmp;
//                pre = pre.next;
//                continue;
//            }
//            post = post.next;
//        }
//        return dummy.next;
//    }



    // for test
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // 两条链，一条链小于x，另一条链大于等于x，最后再合并
    public static ListNode partition(ListNode head, int x) {
        ListNode L1 = new ListNode(0);
        ListNode L2 = new ListNode(0);
        ListNode cur1 = L1;
        ListNode cur2 = L2;
        while (head != null ) {
            if (head.val<x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = L2.next;
        cur2.next = null;
        return L1.next;
    }

    public static void main(String[] args) {
        ListNode L1;
        L1 = new ListNode(1);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(4);
        L1.next.next.next = new ListNode(3);
        L1.next.next.next.next = new ListNode(5);
        L1.next.next.next.next.next = new ListNode(2);
        printList(L1);
        ListNode L2 = partition(L1, 3);
        printList(L2);
    }
}

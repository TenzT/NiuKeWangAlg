package OJExercise.LinkedList;

import java.util.Stack;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// 结果链表
    	ListNode res = new ListNode(0);	
    	ListNode cur = res;	
    	int carry = 0;	// 记录进位情况
    	while (l1 != null && l2 != null) {
    		ListNode tmp = new ListNode(l1.val + l2.val + carry);
    		if (tmp.val>=10) {
        		carry = tmp.val / 10;
        		tmp.val = tmp.val % 10;
        	} else {
        		carry = 0;
        	}
    		// 结果链表插入新节点
    		cur.next = tmp;
    		cur = cur.next;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	// 清空num1
    	while (l1 != null) {
    		ListNode tmp = new ListNode(l1.val + carry);
    		if (tmp.val>=10) {
        		carry = tmp.val / 10;
        		tmp.val = tmp.val % 10;
        	} else {
        		carry = 0;
        	}
    		// 结果链表插入新节点
    		cur.next = tmp;
    		cur = cur.next;
    		l1 = l1.next;
    	}
    	
    	// 清空num2
    	while (l2 != null) {
    		ListNode tmp = new ListNode(l2.val + carry);
    		if (tmp.val>=10) {
        		carry = tmp.val / 10;
        		tmp.val = tmp.val % 10;
        	} else {
        		carry = 0;
        	}
    		// 结果链表插入新节点
    		cur.next = tmp;
    		cur = cur.next;
    		l2 = l2.next;
    	}
    	
    	// 清掉carry
    	if (carry != 0) {
        	ListNode tmp = new ListNode(carry);
        	// 结果链表插入新节点
    		cur.next = tmp;
    		cur = cur.next;
        }
    	
    	return res.next;
    }
    
    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
    	// 先用堆栈存起来
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        while (l1 != null) {
        	num1.push(l1.val);
        	l1 = l1.next;
        }

        while (l2 != null) {
        	num2.push(l2.val);
        	l2 = l2.next;
        }
        int carry = 0;	// 表示进位
        ListNode res = new ListNode(0);
        
        while (!num1.isEmpty() && !num2.isEmpty()) {
        	ListNode tmp = new ListNode(num1.pop() + num2.pop() + carry);
        	if (tmp.val>=10) {
        		carry = tmp.val / 10;
        		tmp.val = tmp.val % 10;
        	} else {
        		carry = 0;
        	}
        	// 结果链表插入新节点
    		tmp.next = res.next;
    		res.next = tmp;
        }
        // 清掉num1
        while (!num1.isEmpty()) {
        	ListNode tmp = new ListNode(num1.pop() + carry);
        	if (tmp.val>=10) {
        		carry = tmp.val / 10;
        		tmp.val = tmp.val % 10;
        	} else {
        		carry = 0;
        	}
        	// 结果链表插入新节点
    		tmp.next = res.next;
    		res.next = tmp;
        }

        // 清掉num2
        while (!num2.isEmpty()) {
        	ListNode tmp = new ListNode(num2.pop() + carry);
        	if (tmp.val>=10) {
        		carry = tmp.val / 10;
        		tmp.val = tmp.val % 10;
        	} else {
        		carry = 0;
        	}
        	// 结果链表插入新节点
    		tmp.next = res.next;
    		res.next = tmp;
        }
        
        if (carry != 0) {
        	ListNode tmp = new ListNode(carry);
        	// 结果链表插入新节点
    		tmp.next = res.next;
    		res.next = tmp;
        }
        
        return res.next;
    }
    
    // for test
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
		ListNode num1 = new ListNode(2);
		num1.next = new ListNode(4);
		num1.next.next = new ListNode(3);
		
		ListNode num2 = new ListNode(5);
		num2.next = new ListNode(6);
		num2.next.next = new ListNode(4);
		
		printList(num1);
		printList(num2);
		printList(addTwoNumbersReverse(num1, num2));
		printList(addTwoNumbers(num1, num2));
		
		
	}
}

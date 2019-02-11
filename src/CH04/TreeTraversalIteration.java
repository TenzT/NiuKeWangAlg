package CH04;

import java.util.Stack;

public class TreeTraversalIteration {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node head = stack.pop();
			System.out.print(head.value + " ");
			if (head.right != null) stack.push(head.right);
			if (head.left != null) stack.push(head.left);
		}
		
	}
	
	// 核心思想：一颗二叉树是可以被左边界划分的
	public static void inOrder(Node node) {
		if (node != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || node!=null) {
				if (node != null) {	// 一路向左打印
					stack.push(node);
					node = node.left;
				} else {	// 遇到左边界的结尾(null)时，找到最左节点，打印完后往右走
					node = stack.pop();
					System.out.print(node.value + " ");
					node = node.right;
				}
			}
			
		}
	}
	
	// 核心思想：仿照前序遍历实现的“中左右”思想改成“中右左”，逆序打印（先压栈再出栈）则变成“左中右”
	public static void posOrder(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(node);
		while (!stack1.isEmpty()) {
			Node head = stack1.pop();
			stack2.push(head);
			if (head.left != null) stack1.push(head.left);
			if (head.right != null) stack1.push(head.right);
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().value + " ");
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
		
		// recursive
		System.out.println("==============iterative==============");
		System.out.print("pre-order: ");
		preOrder(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrder(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrder(head);
		System.out.println();
		
		
	}
}

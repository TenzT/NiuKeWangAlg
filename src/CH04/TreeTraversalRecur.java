package CH04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalRecur {
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
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	public static void posOrder(Node node) {
		if (node == null) {
			return;
		}
		posOrder(node.left);
		posOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	public static void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node head = queue.poll();
			System.out.print(head.value + " ");
			if (head.left != null) 
				queue.add(head.left);
			if (head.right != null) queue.add(head.right);
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
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrder(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrder(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrder(head);
		System.out.println();
		System.out.print("level-order: ");
		levelOrder(head);
		System.out.println();
	}
}

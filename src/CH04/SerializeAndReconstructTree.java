package CH04;

import java.util.LinkedList;
import java.util.Queue;

import CH04.TreeTraversalRecur.Node;

public class SerializeAndReconstructTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static String serializeByPre(Node node) {
		if (node == null) {
			return "#_";
		}
		String res = node.value + "_";
		res += serializeByPre(node.left);
		res += serializeByPre(node.right);
		return res;
	}
	
	public static Node recontructByPre(String preStr) {
		String[] values = preStr.split("_");
		Queue<String> queue = new LinkedList<>();	// Tips:用队列可以代替依次读取的全局数组和，相当于同时传递了arr和cur
		for (int i=0; i<values.length; i++) {
			queue.add(values[i]);
		}
		return recontructByPre(queue);
	}
	private static Node recontructByPre(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node node = new Node(Integer.valueOf(value));
		node.left = recontructByPre(queue);
		node.right = recontructByPre(queue);
		return node;
	}
	
	
	public static void main(String[] args) {
		
		Node head;
		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		String pre = serializeByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = recontructByPre(pre);
		System.out.println(serializeByPre(head));	// 重建前后树结构应该不变
	}
}

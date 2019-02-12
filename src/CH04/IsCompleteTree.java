package CH04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵二叉树是否是完全二叉树
 * 思路：
 * 做这个题思路也是分析单颗树是不是完全二叉树
 * 使用层序遍历，分两种情况可以否定为完全二叉树：
 * 1. 遇到有右子树而没有左子树的情况不是完全二叉树
 * 2. 有左或都没有时，往后遇到非叶节点则不是完全二叉树
 * Tips: 遇到完全二叉树除了前中后序遍历，还可以考虑层序遍历（BFS）
 */
public class IsCompleteTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static boolean isComplete(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<>();
		boolean res = true;	// 记录最终结果
		boolean leafMode = false; // 标记是否已经遇到第二种情况
		queue.add(head);
		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			Node left = tmp.left;
			Node right = tmp.right;
			
			// 有右子树而没有左子树的树不是完全二叉树
			if (left==null && right!=null) {
				return false;
			}
			
			// 有左或都没有时，往后遇到非叶节点则不是完全二叉树
			if (leafMode && ((left!=null)||(right!=null))) {
				return false;
			}
			
			if (left != null) {
				queue.add(left);
			}
			
			if(right!=null) {
				queue.add(right);
			} else {	// 左右节点都没有
				leafMode = true;
			}

			System.out.print(tmp.value + " ");
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.print("尝试CBT: ");
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		System.out.println(isComplete(head));

		System.out.print("尝试非CBT: ");
		head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.left.left.left = new Node(5);
		System.out.println(isComplete(head));
	}
}

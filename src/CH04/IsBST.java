package CH04;

import CH04.TreeTraversalRecur.Node;

/**
 * 小记：做树的题目的常用规律在于使用递归来查看左右子树和父节点是否满足某种关系
 * 判断一棵二叉树是否是平衡二叉树
 * 思路：递归观察每棵树当左子树和右子树平衡且当前子树的左右高度差绝对值小于1时才是平衡
 */
public class IsBST {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;	// 空节点是BST
		}
		boolean resLeft = isBST(head.left);
		boolean resRight = isBST(head.right);
		
		// 任意左右子树不平衡都不可能平衡，此时高度已经不重要了
		if(!resLeft) return false;
		if(!resRight) return false;
		
		boolean resThis = true;
		if (head.left != null) {
			if (head.left.value > head.value) {	// 左节点的值大于当前节点的值时不为BST
				resThis = false;
			}
		}
		if (head.right != null) {
			if (head.right.value < head.value) {	// 右节点的值小于当前节点的值时不为BST
				resThis = false;
			}
		}
		return resThis;
	}
	
	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	
	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		inOrder(head);
		System.out.println(": " + isBST(head));

		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		inOrder(head);
		System.out.println(": " + isBST(head));

	}
}

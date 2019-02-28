package OJExercise.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set toNULL.
 * Initially, all next pointers are set toNULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 */
public class PopulatingNextRightPointers {
	public static class TreeLinkNode{
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		public TreeLinkNode(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
	}
	
	public static class TreeLinkNodeOrder{
		TreeLinkNode node;
		int order;
		public TreeLinkNodeOrder(TreeLinkNode node, int order) {
			// TODO Auto-generated constructor stub
			this.node = node;
			this.order = order;
		}
	}
	public static void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNodeOrder> queue = new LinkedList<>();
		queue.add(new TreeLinkNodeOrder(root, 1));
		while (!queue.isEmpty()) {
			TreeLinkNodeOrder tmp = queue.poll();
			TreeLinkNode node = tmp.node;
			int order = tmp.order;
			if (!queue.isEmpty() && order == queue.peek().order) {
				node.next = queue.peek().node;
			} else {
				node.next = null;
			}
			if (node.left != null) {
				queue.add(new TreeLinkNodeOrder(node.left, order+1));
			}
			if (node.right != null) {
				queue.add(new TreeLinkNodeOrder(node.right, order+1));
			}
		}
    }
	
	public static void main(String[] args) {
		TreeLinkNode root;
		root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
	}
}

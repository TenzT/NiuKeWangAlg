package CH04;
/**
 * 已知一棵完全二叉树，求其节点的个数,要求时间复杂度O(N),N为节点个数
 * 思路：对一棵树做分析，如果左子树是满二叉树，则左子树的节点个数加右子树的节点个数，否则对左子树往下找
 */
public class CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 借用前、中、后序遍历的思想最坏为O(N^2), 基本平衡时为O(N)
	public static int count = 0;
	public static int nodeNum1(Node head) {
		count = 0;
		preOrder(head);
		return count;
	}
	private static void preOrder(Node head) {
		if (head == null) {
			return;
		}
		count = count + 1;
		preOrder(head.left);
		preOrder(head.right);
	}
	
	// 时间复杂度O(lgN)
	/** 思路：如果右子树的左边界到达整棵树的最下层，
	 * 则左子树是满二叉树，调用公式2^l-1+1得到左子树+根节点的节点个数，
	 * 右子树也是一颗完全二叉树，对右子树进行递归调用
	 */
	public static int nodeNum2(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));	// PS: 为什么从1开始？因为如果存在第0层则有 2^0-1=0
	}
	/**
	 * 计算给定完全二叉树中节点的个数
	 * @param head 头
	 * @param level 当前数根所在层数
	 * @param height 整棵树的高度
	 * @return
	 */
	private static int bs(Node head, int level, int height) {
		if (level == height) {
			return 1;	// 最底下的节点只有1个
		}
		// 判断右子树最左的深度到没到整棵树的底部
		if (mostLeftLevel(head.right, level + 1) == height) {	
			// 到了那左子树就是满二叉树,对右子树作递归
			return (1 << (height-level)) + bs(head.right, level+1, height);	
		} else {
			// 还没找到就往左下走
			return (1 << (height-level-1)) + bs(head.left, level+1, height); 
		}
	}
	
	// 找到树有多少层,由于是完全二叉树，所以找到最左的节点即可
	private static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}
	

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.left.left.left = new Node(8);
		head.left.left.right = new Node(9);
		head.left.right.left = new Node(10);
		System.out.println(nodeNum1(head));
		System.out.println(nodeNum2(head));
	}
}

package CH04;
/**
 * 判断一棵二叉树是否是平衡二叉树
 * 思路：递归观察每棵树当左子树和右子树平衡且当前子树的左右高度差绝对值小于1时才是平衡
 */
public class IsBalancedTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static boolean isBalanced(Node head) {
		int[] res = getBalanced(head);	// res[0]=0表示非平衡，1表示平衡
		return res[0]==1 ? true : false;
		
	}
//	public static int[] isBalanced(Node head) // 插播个小细节，重载方法的输入参数类型要不一样，不能仅靠返回类型区分
	public static int[] getBalanced(Node head) {
		if (head == null) {
			return new int[]{1,0};	// 空节点必平衡，且高度为0
		}
		int[] resLeft = getBalanced(head.left);
		int[] resRight = getBalanced(head.right);
		
		// 任意左右子树不平衡都不可能平衡，此时高度已经不重要了
		if(resLeft[0]==0) return new int[]{0,0};
		if(resRight[0]==0) return new int[]{0,0};
		
		return new int[]{
				Math.abs(resLeft[1] - resRight[1])<=1 ? 1 : 0,
				Math.max(resLeft[1], resRight[1]) + 1
		};
		
	}
	
	
	public static void main(String[] args) {
		System.out.print("尝试平衡树: ");
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		System.out.println(isBalanced(head));
		
		System.out.print("尝试非平衡树: ");
		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.left.left = new Node(5);
		System.out.println(isBalanced(head));
		
		System.out.print("尝试非平衡树: ");
		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.right = new Node(4);
		head.left.left = new Node(5);
		head.left.left.left = new Node(6);
		System.out.println(isBalanced(head));
		
		System.out.print("尝试平衡树: ");
		head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.right = new Node(4);
		head.left.left = new Node(5);
		head.left.left.left = new Node(6);
		head.right.left = new Node(7);
		System.out.println(isBalanced(head));
		
	}
}

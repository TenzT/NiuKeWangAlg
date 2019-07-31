package OJExercise.JianZhiOffer;


/**
 * 实现一个函数，判断一棵二叉树是不是对称的
 * @author tenz
 *
 */
public class CheckMirrorTree {
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			super();
			this.value = value;
		}
	}
	
	public static boolean checkMirror(TreeNode root) {
		return doCheck(root, root);
	}
	
	public static boolean doCheck(TreeNode root1, TreeNode root2) {
		// 对称条件1和对称条件2互补
		
		// 对称的条件1，若不满足则跑到条件2
		if (root1 == null && root2 == null) {
			return true;
		}
		
		// 对称条件2，两个非空且值一样且对称路径相同
		// 不满足非空则false
		if (root1 == null || root2 == null) {
			return false;
		}
		// 不满足两个节点值相等
		if (root1.value != root2.value) {
			return false;
		}
		
		// 判断最后路径是否对称
		return doCheck(root1.left, root2.right) && doCheck(root1.right, root2.left);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);	// 改成6的话就变成false
		
		System.out.println(checkMirror(root));
	}
	
}

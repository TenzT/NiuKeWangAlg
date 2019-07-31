package OJExercise.JianZhiOffer;

/**
 * 输入一棵二叉树，该函数输出它的镜像
 * @author tenz
 *
 */
public class MirrorTree {
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			super();
			this.value = value;
		}
	}
	
	public static void makeMirror(TreeNode root) {
		if (root == null) {
			return;
		}
		makeMirror(root.left);
		makeMirror(root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		
		makeMirror(root);
		
		System.out.println(root);
	}
}

package OJExercise.Tree;

import java.util.ArrayList;

public class BinaryTreePostOrderTraversal extends AbstractTree{
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }
	public static void process(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		process(root.left, list);
		process(root.right, list);
		list.add(root.val);
		return;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(postorderTraversal(root));
	}
}

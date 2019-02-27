package OJExercise.Tree;

import java.util.ArrayList;

/*
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * 思路：用一个List存储所有的叶节点形成的数字，每个节点处会把当前节点组成的数传进去
 */
public class SumRootToLeafNumbers extends AbstractTree{
	public static int sumNumbers(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		process(root, list, 0);
		int sum = 0;
		for (Integer num : list) {
			sum += num;
		}
		return sum;
    }
	
	public static void process(TreeNode root, ArrayList<Integer> list, int preNum) {
		// 防御代码
		if (root == null) {
			return;
		}
		preNum = preNum*10 + root.val;
		// 叶子节点
		if (root.left == null && root.right == null) {
			list.add(preNum);
			return;
		}
		
		// 左子树
		if (root.left != null) {
			process(root.left, list, preNum);
		}
		
		// 右子树
		if (root.right != null) {
			process(root.right, list, preNum);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
		
	}
	
}

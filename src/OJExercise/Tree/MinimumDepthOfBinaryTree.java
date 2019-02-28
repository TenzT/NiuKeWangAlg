package OJExercise.Tree;
/**
 * Given a binary tree, find its minimum depth.The minimum 
 * depth is the number of nodes along the shortest path from 
 * the root node down to the nearest leaf node.
 * 思路:使用递归，但是由于寻找最小值，所以边界需要特别抠边界
 * 法2:使用BFS，找到的第一个叶节点的深度就是最浅的深度
 */
public class MinimumDepthOfBinaryTree extends AbstractTree{
	public static int run(TreeNode root) {
		if (root == null) {
            return 0;
        }
		if (root.left == null) {
			return run(root.right) + 1;
		}
		if (root.right == null) {
			return run(root.left) + 1;
		}
		return Math.min(run(root.left), run(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(run(root));
	}
}

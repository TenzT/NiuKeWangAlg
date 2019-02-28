package OJExercise.Tree;

/*
 * Given a binary tree and a sum, determine 
 * if the tree has a root-to-leaf path such 
 * that adding up all the values along the path 
 * equals the given sum.
 */
public class PathSum extends AbstractTree{
	public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
        	return false;
        }
        // 遇到满足条件的叶子节点
        if ((sum-root.val == 0) && root.left==null && root.right==null) {
        	return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        
    }
	public static void main(String[] args) {
		TreeNode root;
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum(root, 22));
		
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(hasPathSum(root, 1));
	}
}

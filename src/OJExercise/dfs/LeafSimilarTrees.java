package OJExercise.dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * Consider all the leaves of a binary tree.  
 * From left to right order, the values of 
 * those leaves form a leaf value sequence.
 */
public class LeafSimilarTrees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = dfs(root1, new ArrayList<Integer>());
        List<Integer> list2 = dfs(root2, new ArrayList<Integer>());
        
        return list1.equals(list2);
    }
	
	// 这种写法可以学习
	public static List<Integer> dfs(TreeNode root, List<Integer> list) {
		if (root == null) {
			return list;
		}
		if (root.left == null && root.right==null) {
			list.add(root.val);
			return list;
		}
		
		dfs(root.left, list);
		dfs(root.right, list);
		return list;
	}
}

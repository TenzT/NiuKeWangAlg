package OJExercise.dfs;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a tree, rearrange the tree in in-order so that the leftmost node 
 * in the tree is now the root of the tree, and every node has no left child 
 * and only 1 right child.
 */
public class IncresingOrderSearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// 小技巧：这里比较简单，直接一直向后传即可，用迭代来代替递归,其实就跟处理单链表一样
	public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traverseInorder(root, list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode dummy = node;
        for (int i=1; i < list.size(); i++) {
        	node.right = new TreeNode(list.get(i));
        	node = node.right;
        }
        return dummy;
    }
	public static void traverseInorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        traverseInorder(root.left, list);
        list.add(root.val);
        traverseInorder(root.right, list);
    }
	
	// 再继续优化的版本则是再inorder的时候就把树给造好了
}

package OJExercise.dfs;

import java.util.List;

/* Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the 
 * longest path from the root node down to the farthest leaf node.
 * 
 * 全部AC
 */
public class MaxmumDepthOfTree {
	public static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	public static int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		int height = 0;
		for (Node child : root.children) {
			height = Math.max(height, maxDepth(child));
		}
		
		height++;
		return height;
    }
	
}

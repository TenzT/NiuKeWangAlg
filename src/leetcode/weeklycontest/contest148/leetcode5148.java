package leetcode.weeklycontest.contest148;import javax.swing.RootPaneContainer;import CH02.MaxGap;

/*
	二叉树着色游戏
	有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
	游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
	「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
	「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
	「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
	之后两位玩家轮流进行操作，每一回合，玩家选择一个之前涂好颜色的节点(只要是自己颜色都可以)，为所选节点 未着色 的一个邻节点（即左右子节点、或父节点）进行染色。
	如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
	若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
	现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
	
 */
public class leetcode5148 {

	// OJ 刷题的时候，这里在实例化时会初始化变量，这些变量就可以当做对象内的全局变量了，防止使用类变量时这一次test的结果影响下一次test
	int ls;
	int rs;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	public int work(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return work(root.left) + work(root.right) + 1;
	}
	
	public void dfs(TreeNode root, int x) {
		if (root == null) {
			return;
		}
		if (root.val == x) {
			ls = work(root.left);
			rs = work(root.right);
		} else {
			dfs(root.left, x);
			dfs(root.right, x);
		}
	}
	
	
	boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		dfs(root, x);
		// 核心, 比较除了x以外所有集合的个数, ls是x的左子树的节点数，rs是右子树的节点数，n-ls-rs-1是x父节点那一片的节点数
		return Math.max(Math.max(ls, rs), n-ls-rs-1) > (n/2);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		leetcode5148 obj = new leetcode5148();
		System.out.println(obj.btreeGameWinningMove(root, 3, 1));
	}
	
}

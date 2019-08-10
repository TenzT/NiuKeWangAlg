package OJExercise.backtracing;

import java.util.ArrayList;
import java.util.List;

/*
 * s给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combination {
	// 结果
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();
	
	// trace
	private List<Integer> trace = new ArrayList<Integer>();
	
	public List<List<Integer>> combine1(int n, int k) {
        dfs(n, 1, k);
		return resList;
    }
	
	// 回溯--增量构造法
	private void dfs(int n, int cur, int k) {
		// 收割结果
		if (trace.size() == k) {
			resList.add(new ArrayList<Integer>(trace));
			return;
		}
		
		if (cur > n) {
			return;
		}
		
		// 不要这个元素
		dfs(n, cur+1, k);
		
		//要这个元素
		trace.add(cur);
		dfs(n, cur+1, k);
		trace.remove(trace.size()-1);
	}
	
	// 用first来表示取或者不取的情况,这种要多参考, 因为分支多是用迭代来处理的
	private void dfs2(int n, int k, int first) {
		// 收割结果
		if (trace.size() == k) {
			resList.add(new ArrayList<Integer>(trace));
			return;
		}
		// 用指针来表示可选的集合
		for (int i=first; i<=n; i++) {
			trace.add(i);
			dfs2(n, k, i+1);
			trace.remove(trace.size()-1);
		}
		
	}
	
	public List<List<Integer>> combine2(int n, int k) {
		dfs2(n, k, 1);
	    return resList;
	}
	
	
	public static void main(String[] args) {
		Combination obj = new Combination();
//		List<List<Integer>> res = obj.combine1(4, 2);
		List<List<Integer>> res = obj.combine2(4, 2);
		System.out.println(res);
		
	}
}

package OJExercise.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * s输入一个集合，找到所有的组合
 */
public class SubSet {
	
	// 结果
	List<List<Integer>> resList = new ArrayList<List<Integer>>();
	
	// 轨迹
	List<Integer> trace = new ArrayList<Integer>();
	
	// 增量构造法
	public List<List<Integer>> subset1(int[] nums) {
		dfs(nums, 0);
		return resList;
	}
	
	
	private void dfs(int[] nums, int cur) {
		if (cur == nums.length) {
			resList.add(new ArrayList<Integer>(trace));
			return;
		}
		
		// 不取当前元素
		dfs(nums, cur+1);
		
		// 取当前元素
		trace.add(nums[cur]);
		dfs(nums, cur+1);
		trace.remove(trace.size()-1);
	}
	
	// 参照迭代的思路
	public List<List<Integer>> subset2(int[] nums) {
		dfs2(nums, 0);
		return resList;
	}
	
	private void dfs2(int[] nums, int first) {
		resList.add(new ArrayList(trace));
		
		for (int i=first; i<nums.length; i++) {
			trace.add(nums[i]);
			dfs2(nums, i+1);
			trace.remove(trace.size()-1);
		}
	}
	
	public static void main(String[] args) {
		SubSet obj = new SubSet();
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = obj.subset2(nums);
		for (List<Integer> set : res) {
			System.out.println(set);
		}
	}
}

package OJExercise.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * s输入一个集合，找到所有的组合
 */
public class Combination {
	
	// 结果
	List<Set<Integer>> resList = new ArrayList<Set<Integer>>();
	
	// 轨迹
	Set<Integer> trace = new HashSet<Integer>();
	
	public List<Set<Integer>> combine(int[] nums) {
		dfs(nums, 0);
		return resList;
	}
	
	
	private void dfs(int[] nums, int cur) {
		if (cur == nums.length) {
			resList.add(new HashSet<Integer>(trace));
			return;
		}
		
		// 不取当前元素
		dfs(nums, cur+1);
		
		// 取当前元素
		trace.add(nums[cur]);
		dfs(nums, cur+1);
		trace.remove(nums[cur]);
	}
	
	public static void main(String[] args) {
		Combination obj = new Combination();
		int[] nums = {1, 2, 3};
		List<Set<Integer>> res = obj.combine(nums);
		for (Set<Integer> set : res) {
			System.out.println(set);
		}
	}
}

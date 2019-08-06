package OJExercise.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * s给定一个没有重复数字的序列，找到全排列，全排列是包含所有数字的
 */
public class Permutation {
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();
	
	private Set<Integer> visitedIndex = new HashSet<Integer>();
			
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> trace = new ArrayList<Integer>();
		dfs(nums, trace);
		return resList;
    }
	
	public void dfs(int[] nums, List<Integer> trace) {
		// 收割结果
		if (trace.size() == nums.length) {
			resList.add(new ArrayList<Integer>(trace));
		}
		
		for (int i=0; i<nums.length; i++) {
			// 回溯法
			if (!visitedIndex.contains(i)) {	// 未用来构建序列
				visitedIndex.add(i);
				trace.add(nums[i]);
				dfs(nums, trace);
				trace.remove(trace.size()-1);	
				visitedIndex.remove(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation obj = new Permutation();
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = obj.permute(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}

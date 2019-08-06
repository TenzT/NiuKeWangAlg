package OJExercise.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * s给定一个没有重复数字的序列，找到全排列，全排列是包含所有数字的
 */
public class Permutation2 {
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();
	
	private Set<Integer> visitedIndex = new HashSet<Integer>();
			
	public List<List<Integer>> permuteUnique(int[] nums) {
		// 先排序
		Arrays.sort(nums);
		
		List<Integer> trace = new ArrayList<Integer>();
		dfs(nums, trace);
		return resList;
    }
	
	public void dfs(int[] nums, List<Integer> trace) {
		// 收割结果
		if (trace.size() == nums.length) {
			resList.add(new ArrayList<Integer>(trace));
		}
		
		for (int i=0; i< nums.length; i++) {
			// 跳过重复元素，visitedIndex.contains(i-1)的条件是说明对除了第一个元素以外的集合做permutation
			if (i > 0 && nums[i] == nums[i - 1] && visitedIndex.contains(i - 1)) {
                i++;
            }
			
			// 回溯法
			if (!visitedIndex.contains(i)) {	// 未用来构建序列\
				visitedIndex.add(i);
				trace.add(nums[i]);
				dfs(nums, trace);
				trace.remove(trace.size()-1);	
				visitedIndex.remove(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation2 obj = new Permutation2();
		int[] nums = {1, 1, 2};
		List<List<Integer>> res = obj.permuteUnique(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}

package OJExercise.backtracing;

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
			// 跳过重复元素, 如果这个数和之前的数一样,并且之前的数还未使用过,那接下来如果走这个分支，
			// 就会使用到之前那个和当前一样的数, 就会发生重复,此时分支和之前的分支一模一样。
			// 减掉可能重复的分支
			if (i > 0 && nums[i] == nums[i - 1] && !visitedIndex.contains(i - 1)) {
                continue;
            }
			
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
		Permutation2 obj = new Permutation2();
		int[] nums = {1, 1, 1, 2};
		List<List<Integer>> res = obj.permuteUnique(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}

package OJExercise.backtracing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/*
 * 给定一个带重复元素的证书数组，返回该数组所有可能的子集
 */
public class SubSet2 {
	private List<List<Integer>> resList = new LinkedList<List<Integer>>();
	
	private List<Integer> trace = new LinkedList<Integer>();
	
	private Set<Integer> visitedIndex = new HashSet<Integer>();
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
        dfs(nums, 0);
        return resList;
    }
	
	private void dfs(int[] nums, int first) {
		resList.add(new LinkedList<Integer>(trace));
		
		for (int i=first; i<nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !visitedIndex.contains(i - 1)) {
                continue;
            }
			
			trace.add(nums[i]);
			visitedIndex.add(i);
			dfs(nums, i+1);
			trace.remove(trace.size()-1);
			visitedIndex.remove(i);
		}
	}
	
	public static void main(String[] args) {
		SubSet2 obj = new SubSet2();
		int[] nums = {1, 2, 2};
		List<List<Integer>> res = obj.subsetsWithDup(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
}

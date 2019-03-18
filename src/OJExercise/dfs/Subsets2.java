package OJExercise.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 给定一个Collection(里面可能有相同的数字)，返回所有可能的子集
 * 要求：
 * 1. 子集中的元素是非递减的
 * 2. 整个结果集合，不能有相同的子集
 * 这里改变之后的难点在于如何避免同样的集合产生，同时又能满足相同的元素也能形成一个集合
 * 思路：这题有重复元素，但本质上，跟上一题很像，相当于可以选0次或若干次
 */
public class Subsets2 {
	// 这种做法是保证按集合大小做一次遍历，每种size往下用增量法dfs，这种情况下不太好总结出递归树
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList();
        
        dfs(nums, 0, path, res);
        
        return res;
    }
    public static void dfs(int nums[], int start, List<Integer> path, 
    		List<List<Integer>> res){
        res.add(new LinkedList<>(path));	// 先把上一步的结果加上
        
        for (int i=start; i < nums.length; i++) {
        	if (i != start && nums[i] == nums[i-1]) {	// 如果和前面相同就不要继续了
        		continue;
        	}
        	path.add(nums[i]);
        	dfs(nums, i+1, path, res);
        	path.remove(path.size()-1);
        }
    }
    
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] set = new int[num];
		for (int i=0; i< num; i++) {
			set[i] = in.nextInt();
		}
		List<List<Integer>> result;
		result = subsetsWithDup(set);
		while (!result.isEmpty()) {
			List<Integer> tmp = result.remove(0);
			if (tmp!=null) {
				for (Integer n : tmp) {
					System.out.print(n + " ");
				}
				System.out.println();
			}
		}
	}
}

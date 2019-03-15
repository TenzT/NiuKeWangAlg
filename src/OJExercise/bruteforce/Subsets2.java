package OJExercise.bruteforce;

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
	// 增量构造法+DFS：用指针指向元素，每个元素都有两种选择，选或者不选
	// 时间复杂度(2^n)，空间复杂度O(n)
	// 关键点：画出递归树就理解了
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int cur = 0; cur <= nums.length; cur++){
            backtrack(res, new ArrayList<Integer>(), nums, 0, cur);
        }
        return res;
    }
    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, 
    		int start, int cur){
        if(cur == 0){	// 到达树底
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]) // 先定好重复元素的最后一位，靠start的移位来扫描多种情况
            	continue;
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1, --cur);
            temp.remove(temp.size()-1);	// 在回溯的情况下，所有情况其实可以共用一个path
        }
        return;
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

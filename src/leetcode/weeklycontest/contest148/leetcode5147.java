package leetcode.weeklycontest.contest148;

import java.util.PrimitiveIterator.OfDouble;

/**
 * s给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1
 * s 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * s每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * s或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * s返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * @author t50002654
 * 100%AC
 */
public class leetcode5147 {
	
	public static void main(String[] args) {
//		int[] nums = new int[]{1, 2, 3};
//		int[] nums = new int[]{9, 6, 1, 6, 2};
		int[] nums = new int[]{2, 7, 10, 9, 8, 9};
		
		System.out.println(movesToMakeZigzag(nums));
	}

	public static int movesToMakeZigzag(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		
		// 令偶数index更大的操作数
		int steps2MakeEvenSmaller = 0;
        
        // 令奇数index更大的操作数
        int steps2MakeOddSmaller = 0;
         
        for (int index = 0; index<nums.length; index++) {
        	if (index % 2 == 0) {	// 令偶数更小
        		if (index == nums.length-1) {
        			if (nums[index-1]<=nums[index]) {	// 有左无右
        				steps2MakeEvenSmaller += nums[index] - nums[index-1] + 1;
        			}
        		} else if (index == 0){	// 有右无左
        			if (nums[index] >= nums[index+1]) {
        				steps2MakeEvenSmaller += nums[index] - nums[index+1] + 1;
        			}
        		} else {	// 有左有右
    				if (nums[index] >= Math.min(nums[index-1], nums[index+1])) {
    					steps2MakeEvenSmaller += nums[index] - Math.min(nums[index-1], nums[index+1]) + 1;
    				}
    			}
        	} else {	// 令奇数更小
        		if (index == nums.length-1) {
        			if (nums[index-1]<=nums[index]) {	// 有左无右
        				steps2MakeOddSmaller += nums[index] - nums[index-1] + 1;
        			}
        		} else {	// 有左有右
    				if (nums[index] >= Math.min(nums[index-1], nums[index+1])) {
    					steps2MakeOddSmaller += nums[index] - Math.min(nums[index-1], nums[index+1]) + 1;
    				}
    			}
        	}
        }
        
        return Math.min(steps2MakeEvenSmaller, steps2MakeOddSmaller);
    }
}

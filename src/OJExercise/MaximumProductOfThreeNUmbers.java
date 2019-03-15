package OJExercise;

import java.util.Arrays;

/*
 * 给定一个数组，从里面找三个数使得他们的乘积最大
 * 有可能会出现负数
 */
public class MaximumProductOfThreeNUmbers {
	public static int maximumProduct(int[] nums) {
		if (nums == null || nums.length <3) {
			return 0;
		}
		int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= 0) {
            return nums[len-1] * nums[len-2] *nums[len-3];
        } else if(nums[len-1]<0) {
        	return nums[0] * nums[1] * nums[len-1];
        } else {
        	return Math.max(nums[0] * nums[1] * nums[len-1], nums[len-3] * nums[len-2] * nums[len-1]);
        }
    }
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4};
		maximumProduct(arr);
	}
}

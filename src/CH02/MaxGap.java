package CH02;
/**
 * 给定一个数组， 求如果排序之后， 相邻两数的最大差值，
 * 要求时间复杂度O(N)， 且要求不能用非基于比较的排序。
 * 思路：借助桶排序和抽屉原理的思想,在最大最小值之间划分(N+1)个桶，
 * 空桶的作用在于否定最大差值存在于同一个桶的可能性，因此最大差值必然存在不同桶之间，
 * 因此每个桶只需要存最大值和最小值即可
 * 细节：
 * 1. 只用来处理非负整数
 * 2. max放在N+1号桶，[min,max)范围上的数放在1～N号桶中，负责区间为(max - min)/N
 */
import java.util.Arrays;

public class MaxGap {
	public static int maxGap(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int len = arr.length;	
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// 找到最大最小值
		for (int i=0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if (min == max) {
			return 0;
		}
		
		// 创建 N + 1 个桶，表示 N + 1 个区间
		boolean[] hasNum = new boolean[len + 1];    // 后面用于判断是不是空桶
		int[] maxs = new int[len + 1];	// 桶相应index的最大值
		int[] mins = new int[len + 1];	// 桶相应index的最小值
		// 关键部分开始, 将不同的数放进相应区域的桶
		for (int i = 0; i < len; i++) {
			int bid = bucket(arr[i], len, min, max);   // 判断一个数字该去几号桶
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
			hasNum[bid] = true;
		}
		int maxGap = 0;
		int lastMax = maxs[0];	// 上一个桶的最大值, 这是跨桶遍历的trick
		for (int i=1; i <= len; i++) {
			if(hasNum[i]) {
				maxGap = Math.max(maxGap, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return maxGap;
	}
	
	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num-min)*len / (max-min));
	}
	
	/****测试用工具***/
	// 对数器，绝对正确，但是时间复杂度高
	public static int comparator(int[] nums) {
		if (nums == null ||nums.length <2) {
			return 0;
		}
		Arrays.sort(nums);
		int maxGap = Integer.MIN_VALUE;
		for(int i=1; i<nums.length; i++) {
			maxGap = Math.max(maxGap, nums[i] - nums[i-1]);
		}
		return maxGap;
	}
	
	// 赋值数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for(int i=0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	// 生成随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{0, 11, 37, 39, 43, 47, 60, 70, 99};
		maxGap(arr);
		
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i=0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (maxGap(arr1) != comparator(arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}

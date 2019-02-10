package CH02;

import java.util.Arrays;

/**
 * 基数排序
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 具体做法是：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序
 * 完成以后, 数列就变成一个有序序列。优点是只需要10个桶（因为十位数每个位上范围是0～9）
 */

public class RadixSort {
	public static void radixSort(int[] arr) {
		if (arr==null || arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length-1, getMaxBit(arr));
	}
	
	private static int getMaxBit(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i=0;i<arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int count = 0; //记录最大位数
		while(max != 0) {
			count++;
			max /= 10;
		}
		return count;
	}
	
	private static int getDigit(int num, int digit) {
		return ((num / ((int) Math.pow(10, digit - 1))) % 10);
	}

	/*******好好回顾*********/
	private static void radixSort(int[] arr, int begin, int end, int maxBit) {
		int radix = 10;		//基数为10
		int[] count = new int[radix];		// 0到9,桶的个数并在单词排序中使用计数排序
		int[] bucket = new int[end-begin+1];	// 实际的桶结构
		for (int d=1; d <= maxBit; d++) {	// 从个位数开始遍历
			count = new int[radix];	//count 清零
			
			// 作"词频统计"
			for (int i=0; i<arr.length; i++) {
				int j = getDigit(arr[i], d);	// 拿到相应位数上的数字
				count[j]++;
			}
			// 调整count,使得桶上的数字标志的是实际桶的index的上界
			for (int i=1;i<count.length; i++) {
				count[i] = count[i] + count[i-1];
			}
			
			// 重构数组
			for(int i=end; i>=begin; i--) {
				int j = getDigit(arr[i], d);	// 取出第d位上的数字
				bucket[count[j]-1] = arr[i];
				count[j]--;
			}
			for (int i = begin, j = 0; i <= end; i++, j++) {
				arr[i] = bucket[j];
			}
			
		}
	}
	/********************/
	
	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int testTime = 5000;
		int maxSize = 100;
		int maxValue = 100000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			radixSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

	}
}

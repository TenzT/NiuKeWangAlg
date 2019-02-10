package CH02;

import java.util.Arrays;

/**
 * 桶排序——计数排序
 * 思路: 先建立一个数组，索引范围从0到arr的最大值，先做“频数统计”，再重构arr
 * 局限: 当最大值特别大时，不可能做一个很大的数组
 */
public class BucketSort {
	// 只打算搞定0~200的数值
	public static void bucketSort(int[] arr) {
		if (arr== null || arr.length<2) {
			return;
		}
		int max = Integer.MIN_VALUE;
		// 遍历找到最大值
		for(int n : arr) {
			max = Math.max(max, n);
		}
		
		int[] bucket = new int[max + 1];	// 左闭右闭区间
		// "频数统计"
		for (int i=0; i< arr.length; i++) {
			bucket[arr[i]]++;
		}

		// 重构arr
		int i=0;
		for (int j=0; j < bucket.length; j++) {
			while (bucket[j]-- > 0) {
				arr[i++] = j;
			}
		}
		
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
	
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 150;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			bucketSort(arr1);
			comparator(arr2);	// 正确的方法
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);	// 打印自己写的方法
				printArray(arr2);	// 打印绝对正确的方法的结果
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//		int[] arr = generateRandomArray(maxSize, maxValue);
//		printArray(arr);
//		bucketSort(arr);
//		printArray(arr);

	}
}

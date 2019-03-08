package OJExercise.JianZhiOffer;

/*
 * 不修改数组找出重复的数字
 * 
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 找出该重复数字
 * 
 * 优化思路：二分查找
 * 测试用例：
 * 1. 长度为n的数组里包含一个或多个重复数字
 * 2. 数组中不包含重复数字
 * 3. 空指针或者超出
 */
public class DuplicateInArrayNoEdit {
	// 法1和DuplicateInArray用哈希表差不多，这里不重复
	
	// 法2 使用二分查找优化空间复杂度，再加上统计
	// 还是利用1~n这个信息，选定一个中间的数字m，如果1~m的数字的数目超过m，那么这一半的取件里一定包含重复数字；
	// 否则另一半区间m+1~n里一定包含重复的数字。因为如果没有重复数字的话，那么1~n的范围里只有n个数字
	// 区间是虚的，并没有真正的数据结构出来，只是用范围来表征
	public static int duplicate(int[] numbers) {
		if (numbers == null) {
			return -1;
		}
		int lenght = numbers.length;
		int start = 1;
		int end = lenght - 1;
		// 不断的二分查找区域
		while(end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(numbers, start, middle);
			// 结束条件
			if (end == start) {
				if (count > 1) {	// 在前半部分
					return start;
				} else {
					break;
				}
			}
			// 往下二分查找
			if (count > (middle-start + 1))	{	// 如果区间内的数大于中位数，则重复数字在前半区间
				end = middle;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}
	
	// 统计整个数组中出现在给定区间中的数字的个数
	public static int countRange(int[] numbers, int start, int end) {
		if (numbers == null) {
			return 0;
		}
		int count = 0;
		for (int i=0; i < numbers.length; i++) {
			if (numbers[i] >= start && numbers[i] <= end) {
				count++;
			}
		}
		return count;
		
	}
	public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(duplicate(arr));

        arr = new int[]{2, 11, 1, 0, 2, 5, 3};
        System.out.println(duplicate(arr));
    }
}

package OJExercise;

/*
 * 给定一个排序数组，需要在原地删除重复出现的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicateArray {
	// 思路：借鉴Arraylist的思想，给定一个尾指针就好操作了
	public static int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int tail = nums.length - 1;
		for (int i=0; i< tail;) {
			if (nums[i]==nums[i+1]) {
				int j = i;
				while (j < tail) {
					nums[j] = nums[j+1];
					j++;
				}
				tail--;
			} else {
				i++;
			}
		}
		return tail+1;
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1, 1, 2, 3, 3, 4};
		int[] arr = new int[]{1, 1, 1, 2};
		System.out.println(removeDuplicates(arr));
	}
}

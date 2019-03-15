package OJExercise;

/*
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class SpinArray {
	public static void spin(int[] nums, int k) {
		if (nums == null) {
			return;
		}
		k %= nums.length;
		int buff = 0;
		for (int i=0; i < k; i++) {
			buff = nums[nums.length-1];
			for (int j=nums.length-1; j>0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = buff;
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		spin(nums, 3);
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}
}

package OJExercise;

/*
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeros {
	public static void moveZeroes(int[] nums) {
        if (nums == null) {
        	return;
        }
        
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}
}

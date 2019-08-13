package OJExercise.DynamicProgramming;

public class CuttingRope {
	
	// DP版本
	public static int maxProduct1(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		int[] product = new int[length + 1];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		product[3] = 3;
		
		for (int i=4; i <=length; i++) {
			int max = 0;
			for (int j=1; j <= i/2; j++) {
				int pro = product[j] * product[i-j];
				if (max < pro) {
					max = pro;
				}
				product[i] = max;
			}
		}
		return product[length];
	}
	
	// 递归版本，长度不能小于4
	public static int maxProduct2(int length) {
		// basecase
		if (length<2) {
			return 0;
		} else if (length == 2) {
			return 2;
		} else if (length == 3) {
			return 3;
		}
		
		int max = 0;
		for (int i=1; i<=length/2; i++) {
			max = Math.max(max, maxProduct2(i)*maxProduct2(length-i));
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProduct1(8));
		System.out.println(maxProduct2(8));
	}
}

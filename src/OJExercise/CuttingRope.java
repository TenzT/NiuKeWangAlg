package OJExercise;

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
	
	public static void main(String[] args) {
		System.out.println(maxProduct1(8));
	}
}

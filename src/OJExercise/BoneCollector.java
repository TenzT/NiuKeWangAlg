package OJExercise;
/*
 * 0-1背包问题
 */
import java.util.Scanner;

public class BoneCollector {
	
	// 暴力递归
	public static int maxValue1(int[] weights, int[] values, int volumn) {
		return process1(weights, values, 0, volumn);
	}
	public static int process1(int[] weights, int[] values, int cur, int volumn) {
		if(cur == weights.length) {
			return 0;
		}
		// 装不下这次的物件就不拿了
		if (volumn - weights[cur] < 0) {
			return 0;
		}
		// 拿了这个物件的结果
		int resInclude = values[cur] + process1(weights, values, cur+1, volumn - weights[cur]);
		// 不拿这个物件的结果
		int resReclude = process1(weights, values, cur+1, volumn);
		return Math.max(resInclude, resReclude);
	}
	
	// dp版本
	public static int maxValue2(int[] weights, int[] values, int volumn) {
		if (weights == null || values == null) {
			return 0;
		}
		int[][]dp = new int[weights.length+1][volumn+1];	// dp二维数组
		// basecase都是0，所以不管
		for (int i = weights.length-1; i >= 0; i--) {
			for (int j = volumn; j >= 0; j--) {
				dp[i][j] = dp[i+1][j];	// 不拿这个物件的情况
				if (j + weights[i] <= volumn) {	// 拿这个物件的情况
					dp[i][j] = Math.max(
							values[i] + dp[i+1][j + weights[i]], 
							dp[i][j]);
				}
			}
		}
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int volumn = in.nextInt();
		int[] values = new int[number];
		int[] weights = new int[number];
		for (int i=0; i< values.length; i++) {
			values[i] = in.nextInt();
		}
		for (int i=0; i< weights.length; i++) {
			weights[i] = in.nextInt();
		}
		/*
		 * 测试用例
		 * 5 10
		 * 1 2 3 4 5
		 * 5 4 3 2 1
		 * 
		 * 4 6
		 * 4 6 12 7
		 * 1 2 3 2
		 */
		System.out.println(maxValue1(weights, values, volumn));
		System.out.println(maxValue2(weights, values, volumn));
		
	}
}

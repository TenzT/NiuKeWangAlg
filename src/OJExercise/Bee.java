package OJExercise;

import java.util.Scanner;

/*来源：hdu 2044 http://acm.hdu.edu.cn/showproblem.php?pid=2044
 * 有一只经过训练的蜜蜂只能爬向右侧相邻的蜂房，不能反向爬行。
 * 蜂房结构为蛇形结构
 * 请编程计算蜜蜂从蜂房a爬到蜂房b的可能路线数。
 */
public class Bee {
	// 递归版本
	public static int beeCount1(int start, int end) {
		return recursiveCore(end-start+1);
	}
	private static int recursiveCore(int n) {
		if (n <= 0 ) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return recursiveCore(n-1) + recursiveCore(n-2);
	}
	
	// dp版本
	public static int beeCount2(int start, int end) {
		int n = end-start+1;
		// base case
		if (n <= 0 ) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i=3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int start = in.nextInt();
			int end = in.nextInt();
			System.out.println(beeCount1(start, end));
			System.out.println(beeCount2(start, end));
		}
	}
}

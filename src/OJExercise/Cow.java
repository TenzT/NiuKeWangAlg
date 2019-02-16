package OJExercise;

import java.util.Scanner;

/* 向前递推
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 */
public class Cow {
	// 递归版本
	public static int cowCount1(int n) {
		if (n == 0 || n == 1 || n == 2 || n == 3) {
			return n;
		}
		return cowCount1(n-1) + cowCount1(n-3);
	}
	
	// dp版本
	public static int cowCount2(int n) {
		if (n == 0 || n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[] dp = new int[n+1]; // dp数组
		// 设置basecase
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i=4; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-3];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			System.out.println(cowCount1(n));
			System.out.println(cowCount2(n));
		}
	}
}

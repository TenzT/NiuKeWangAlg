package OJExercise.DynamicProgramming;

import java.util.Scanner;

/*
 * 给定整数N，返回斐波那契数列数列的第N项
 */
public class Fibonacci {
	public static long fabDP(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		long[] dp = new long[n+1];
		// basecase
		dp[1] = 1;
		dp[2] = 1;
		for (int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			System.out.println(fabDP(in.nextInt()));
		}
	}
}

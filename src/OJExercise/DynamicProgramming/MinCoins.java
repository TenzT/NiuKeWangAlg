package OJExercise.DynamicProgramming;

import java.util.Scanner;

/*
 * 给定数组arr，arr中所有的值都为正数且不重复，每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求组成aim的最少货币数
 */
public class MinCoins {
	public static long minCoins(int[] money, int aim) {
		if (money == null) {
			return -1;
		}
		int numTypes = money.length;
		long[][] dp = new long[numTypes][aim+1];	// dp[i][j] 表示aim为j时的最少张数
		
		long max = Integer.MAX_VALUE;	// 表示找不开的
		// basecase 表示只能用money[0]的情况下，找某个钱数的最少张数
		for (int j=1; j <=aim; j++) {
			dp[0][j] = max;		// 默认是找不开的
			if (j-money[0]>=0 && dp[0][j-money[0]] != max) {
				dp[0][j] = dp[0][j - money[0]] + 1;
			}
		}
		/* 递推规则：从左向右，从上到下，
		 * dp[i][j] = min{dp[i-1][j], dp[i][j-arr[i]]+1}
		 * dp[i-1][j]表示不用当前货币，后面一种情况需要推导，从dp[i][j-k*arr[i]]+k 得来
		 * 递归树跟全集合的路径有点像
		 */
		long left = 0;
		for (int i=1; i < numTypes; i++) {
			for (int j=1; j <= aim; j++) {
				left = max;
				if (j-money[i] >=0 && dp[i][j-money[i]]!=max) {
					left = dp[i][j-money[i]] + 1;
				}
				// left是选当前货币的结果，dp[i-1][j]是不选当前货币的结果，选最小值
				dp[i][j] = Math.min(left, dp[i-1][j]);
			}
		}
		return dp[numTypes-1][aim] != max ? dp[numTypes-1][aim] : -1;	// -1表示不存在此方案
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int numTypes = in.nextInt();	// 货币种类
			int aim = in.nextInt();	// 目标
			int[] money = new int[numTypes];
			for (int i=0; i < numTypes; i++) {
				money[i] = in.nextInt();
			}
			System.out.println(minCoins(money, aim));
		}
	}
}

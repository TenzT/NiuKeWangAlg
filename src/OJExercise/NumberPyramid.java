package OJExercise;

import java.util.Scanner;

/* 向前递推
 * 输入一个数塔，每个节点可以选择从左走或者从右走，
 * 要求一直走到塔底，使得走过的路径上的数值和最大
 * 思路: f(m,n) = value(m,n) + max{f(m+1,n), f(m+1,n+1)}
 */
public class NumberPyramid {
	// 暴力递归
	public static long maxSum1(int[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		return process1(matrix, 0, 0);
	}
	public static long process1(int[][] matrix, int row, int column) {
		// 到达塔底
		if (row == matrix.length-1) {
			return matrix[row][column];
		}
		long max = matrix[row][column] + 
				Math.max(process1(matrix, row+1, column),
						process1(matrix, row+1, column+1));

		return max;
	}
	
	// DP解法
	public static long maxSum2(int[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		int row = matrix.length;
		int column = matrix[0].length;
		long[][] dp = new long[matrix.length][matrix[0].length];	// 二维dp矩阵
		// basecase
		for (int i=0; i < column; i++) {
			dp[row-1][i] = matrix[row-1][i];
		}
		
		// dp开始
		for (int i=row-2; i>=0; i--) {
			for (int j=i; j>=0; j--) {
				dp[i][j] = matrix[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[][] pyramid = new int[][]{
			{13, 0, 0, 0, 0},
			{11, 8, 0, 0, 0},
			{12, 7, 26, 0, 0},
			{6, 14, 15, 8, 0},
			{12, 7, 13, 24, 11}};
		System.out.println(maxSum1(pyramid));
		System.out.println(maxSum2(pyramid));
		
		// 输入自己的用例
		/*
		 * 5
		 * 9
		 * 12 15
		 * 10 6 8
		 * 2 18 9 5
		 * 19 7 10 4 16
		 * 正确输出为59
		 */
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();	// 数塔高度
		pyramid  = new int[N][N];
		for (int i=0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				pyramid[i][j] = in.nextInt();
			}
			for (int j=i+1; j < N; j++) {
				pyramid[i][j] = 0;
			}
		}
		System.out.println(maxSum1(pyramid));
		System.out.println(maxSum2(pyramid));
	}
}

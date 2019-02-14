package CH08;
/*
 * 给你一个二维数组， 二维数组中的每个数都是正数， 要求从左上
 * 角走到右下角， 每一步只能向右或者向下。 沿途经过的数字要累
 * 加起来。 返回最小的路径和。
 */

public class MatrixMinPath {
	
	// 暴力递归版本
	public static int minPath1(int[][] matrix) {
		return process1(matrix, matrix.length-1, matrix[0].length-1);	// 放最后一个点进去
	}
	private static int process1(int[][] matrix, int row, int column) {
		int res = matrix[row][column];
		// 最左上角的点
		if (row == 0 && column == 0) {
			return res;
		}
		// 最上面的行
		if (row == 0 && column != 0) {
			return res + process1(matrix, row, column - 1);
		}
		// 最左面的列
		if (column == 0 && row != 0) {
			return res + process1(matrix, row - 1, column);
		}
		// 普遍情况
		return res + Math.min(process1(matrix, row, column - 1), 
				process1(matrix, row - 1, column));
	}
	
	// 动态规划版本
	public static int minPath2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int[][] dp = new int[matrix.length][matrix[0].length];	// 结果数组
		// 复制basecase
		dp[0][0] = matrix[0][0];
		for (int i = 1; i < matrix.length; i++) {
			dp[i][0] = dp[i - 1][0] + matrix[i][0];
		}
		for (int j = 1; j < matrix[0].length; j++) {
			dp[0][j] = dp[0][j - 1] + matrix[0][j];
		}
		for (int i=1; i < matrix.length; i++) {
			for (int j=1; j < matrix[0].length; j++) {
				dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[matrix.length-1][matrix[0].length-1];	
	}
	
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
	}
}

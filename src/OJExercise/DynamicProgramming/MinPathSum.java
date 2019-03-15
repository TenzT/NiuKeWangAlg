package OJExercise.DynamicProgramming;

import java.util.Scanner;

public class MinPathSum {
	public static int minPathSum1(int[][] matrix) {
		if (matrix == null) {
			return -1;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row][col];
		// basecase
		dp[0][0] = matrix[0][0];
		for (int i=1; i<row; i++) {
			dp[i][0] = dp[i-1][0] + matrix[i][0];
		}
		for (int i=1; i<col; i++) {
			dp[0][i] = matrix[0][i-1] + matrix[0][i];
		}
		
		for (int i=1; i < row; i++) {
			for (int j=1; j < col; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
			}
		}
		return dp[row-1][col-1];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int row = in.nextInt();
			int col = in.nextInt();
			int[][] matrix = new int[row][col];
			for (int i=0; i< row; i++) {
				for (int j=0; j < col; j++) {
					matrix[i][j] = in.nextInt();
				}
			}
			
			System.out.println(minPathSum1(matrix));
		}
	}
}

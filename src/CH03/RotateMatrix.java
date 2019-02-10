package CH03;
/**
 * 给定一个整型正方形矩阵matrix， 请把该矩阵调整
 * 成顺时针旋转90度的样子
 */
public class RotateMatrix {
	private static void rotate(int[][] matrix, int topRow, int topColumn, int downRow, int downColumn) {
		int times = downColumn - topColumn;
		// 旋转的细节，坐标的变换
		for (int i=0; i<times; i++) {
			int tmp = matrix[topRow][topColumn + i];	// 拿出来暂存一下
			matrix[topRow][topColumn + i] = matrix[downRow-i][topColumn];
			matrix[downRow-i][topColumn] = matrix[downRow][downColumn-i];
			matrix[downRow][downColumn-i] = matrix[topColumn + i][downColumn];
			matrix[topColumn + i][downColumn] = tmp;
		}
		
	}
	public static void ratateMatrix(int[][] matrix) {
		int topRow = 0;
		int topColumn = 0;
		int downRow = matrix.length - 1;
		int downColumn = matrix[0].length - 1;
		while(topRow < downRow) {
			rotate(matrix, topRow++, topColumn++, downRow--, downColumn--);
		}
		
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4},
									{5,6,7,8},
									{9,10,11,12},
									{13,14,15,16}};
		printMatrix(matrix);
		System.out.println();
		ratateMatrix(matrix);
		System.out.println();
		printMatrix(matrix);
	}
}

package CH03;
/**
 * 给定一个整型矩阵matrix， 请按照顺时针转圈的方式打印它。
 * 思路：宏观调度题，先抽离出核心的可复用的步骤，在本题中是给定左上角和右下角，
 * 逆时针转圈打印矩阵的边缘，往内收窄一圈后重复
 */
public class PrintSpiralMatrix {
	private static void printEdge(int[][] matrix, int topRow, int topColumn, int downRow, int downColumn) {
		if (matrix == null) {
			throw new RuntimeException("矩阵为空，不可打印");
		}
		// 处理只有一行的情况
		if (topRow == downRow) {
			for (int i=topColumn; i<= downColumn; i++) {
				System.out.print(matrix[topRow][i] + " ");
			}
		} else if (topColumn == downColumn) { // 处理只有一列的情况
			for (int i=topRow; i<= downRow; i++) {
				System.out.print(matrix[i][topColumn] + " ");
			}
		} else {	// 完整矩阵
			for (int i=topColumn; i < downColumn; i++) {
				System.out.print(matrix[topRow][i] + " ");
			}
			for (int i=topRow; i < downRow; i++) {
				System.out.print(matrix[i][downColumn] + " ");
			}
			for (int i=downColumn; i > topColumn; i--) {
				System.out.print(matrix[downRow][i] + " ");
			}
			for (int i=downRow; i > topRow; i--) {
				System.out.print(matrix[i][topColumn] + " ");
			}
		}
		
	}
	
	public static void printSpiralMatrix(int[][] matrix) {
		int topRow = 0;
		int topColumn = 0;
		int downRow = matrix.length - 1;
		int downColumn = matrix[0].length - 1;
		while(topRow < downRow) {
			printEdge(matrix, topRow++, topColumn++, downRow--, downColumn--);
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
		printSpiralMatrix(matrix);
	}
}

package CH03;
/**
 * 给定一个整型正方形矩阵matrix，使用
 * Zig-Zag路径打印矩阵
 */
public class ZigZagPrint {
	public static void zigZagPrint(int[][] matrix) {
		int topRow = 0;
		int topColumn = 0;
		int downRow = 0;
		int downColumn = 0;
		int endRow = matrix.length - 1 ;
		int endColumn = matrix[0].length - 1;
		boolean isUp = true;	// 是否向上扫描
		while (topRow <= endRow) {
			printLevel(matrix, topRow, topColumn, downRow, downColumn, isUp);
			topRow = topColumn == endColumn? topRow+1 : topRow;	// 和下一行顺序不可调换
			topColumn = topColumn == endColumn? topColumn : topColumn + 1;
			downColumn = downRow == endRow? downColumn + 1 : downColumn;	// 和下一行顺序不可调换
			downRow = downRow == endRow? downRow : downRow + 1;		
			isUp = !isUp;
		}
		
	}
	
	// 打印对角线
	private static void printLevel(int[][] matrix, int topRow, int topColumn, 
			int downRow, int downColumn, boolean isUp) {
		if (isUp) {	// 向上画
			for (int i=downRow; i>=topRow;) {
				System.out.print(matrix[i--][downColumn++] + " ");
			}
		} else {
			for (int i=topRow; i<=downRow;) {
				System.out.print(matrix[i++][topColumn--] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		zigZagPrint(matrix);
	}
}

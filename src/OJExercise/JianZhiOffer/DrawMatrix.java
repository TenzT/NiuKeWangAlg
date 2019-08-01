package OJExercise.JianZhiOffer;

/**
 * 
 * @author t50002654
 *  s输入一个矩阵，按照从外向里以顺时针的顺序一次打印出每一个数字
 */
public class DrawMatrix {
	public static void main(String[] args) {
		int[][] inputMat= {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		
		drawMat(inputMat);
		
	}
	
	
	static void drawMat(int[][] inputMat) {
		if (inputMat == null || inputMat.length <=0 || inputMat[0].length<=0) {
			return;
		}
		
		int start = 0;
		
		int row = inputMat.length;
		int column = inputMat[0].length;
		
		while (start*2 < column && start *2 < row) {
			doDraw(inputMat, column, row, start);
			start++;
		}
	}
	
	/**
	 * s画矩阵环
	 * @param inputMat 把矩阵看成一圈圈的数据
	 * @param columns
	 * @param rows
	 * @param start 由于矩阵环的起点的轨迹是左上顶角向右走，因此起点坐标值只需要一个，大的结束条件是start到达中心
	 */
	static void doDraw(int[][] inputMat, int columns, int rows, int start) {
		int endX = columns - start - 1;
		int endY = rows - start - 1;
		
		// 从左向右打印第一行
		for (int i=start; i<= endX; i++) {
			System.out.printf("%d ", inputMat[start][i]);
		}
		
		// 从上向下打印右边，添加if是考虑只有一行的情况
		if (start < endY) {
			for (int i= start+1; i <=endY; i++) {
				System.out.printf("%d ", inputMat[i][endX]);
			}
		}
		
		// 从右向左打印最后一行，添加if是考虑只有一列的情况
		if (start<endX && start<endY) {
			for (int i=endX - 1; i>=start; i--) {
				System.out.printf("%d ", inputMat[endY][i]);
			}
		}
		
		// 从下向上打印最左一列
		if (start<endX && start<endY-1) {
			for (int i=endY-1; i>start; i--) {
				System.out.printf("%d ", inputMat[i][endX]);
			}
		}
		
	}
}

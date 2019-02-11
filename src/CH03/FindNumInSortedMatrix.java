package CH03;
/**
 * 在行列都排好序的矩阵中找数
 */
public class FindNumInSortedMatrix {
	public static boolean containsFromTopRight(int[][] matrix, int num) {
		int row = 0;
		int column = matrix[0].length - 1;
		while (row<matrix.length && column>=0) {
			if (matrix[row][column] == num) {
				return true;
			} else if (matrix[row][column] > num) {
				column--;
			} else {
				row++;
			}
		}
		return false;
	}
	
	public static boolean containsFromDownLeft(int[][] matrix, int num) {
		int row = matrix.length - 1;
		int column = 0;
		while (row >=0 && column<matrix[0].length) {
			if (matrix[row][column] == num) {
				return true;
			} else if (matrix[row][column] < num) {
				column++;
			} else {
				row--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
				{ 10, 12, 13, 15, 16, 17, 18 },// 1
				{ 23, 24, 25, 26, 27, 28, 29 },// 2
				{ 44, 45, 46, 47, 48, 49, 50 },// 3
				{ 65, 66, 67, 68, 69, 70, 71 },// 4
				{ 96, 97, 98, 99, 100, 111, 122 },// 5
				{ 166, 176, 186, 187, 190, 195, 200 },// 6
				{ 233, 243, 321, 341, 356, 370, 380 } // 7
		};
		int K = 11;
		System.out.println(containsFromTopRight(matrix, K));
		System.out.println(containsFromDownLeft(matrix, K));
	}
}

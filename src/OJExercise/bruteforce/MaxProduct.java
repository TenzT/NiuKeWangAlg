package OJExercise.bruteforce;

/**
 * s输入n个元素组成的序列S，你需要找出一个乘积最大的连续子序列。如果这个最大的乘积不是正数，应输出-q
 * @author tenz
 *
 */
public class MaxProduct {
	
	public static void main(String[] args) {
		MaxProduct obj = new MaxProduct();
		int[] arr1 = {2,5,-1,2,-1};
		int[] arr2 = {2,4,-3};
		int[] arr3 = {-4,3};
		System.out.println(obj.maxProduct(arr1));
		System.out.println(obj.maxProduct(arr2));
		System.out.println(obj.maxProduct(arr3));
	}

	public long maxProduct(int[] arr) {
		int n = arr.length;
		long res = -1;
		
		for (int i=0; i < n; i++) {
			long tmpProduct = arr[i];
			for (int j=i+1; j < n; j++) {
				tmpProduct *= arr[j];
				res = Math.max(tmpProduct, res);
			}
			res = Math.max(tmpProduct, res);
		}
		
		return res;
		
	}
}

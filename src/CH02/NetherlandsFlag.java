package CH02;

/**
 * 
 * @author tandezhi
 * 荷兰国企问题，给定数组arr和一个num，把小于num的数放在数组的左边， 
 * 等于num的数放在数组的中间， 大于num的数放在数组的右边。
 * 要求时间复杂度为O(N)
 */
public class NetherlandsFlag {
	private static int[] partition(int[] arr, int low, int high, int num) {
		int less = low - 1;	 // index小于等于less的都小于p
		int more = high + 1;	// index大于等于more的都小于p
		while (low < more) {
			if (arr[low] < num) swap(arr, low++, ++less);	// 先多拿一个位置再交换
			else if (arr[low] > num) swap(arr, low, --more);	
			else low++;
		}
		
		return new int[] {less+1, more-1};
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int[] generateArray(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * N/3);
		}
		return arr;
	}
	
	public static void printArray(int[] arr) {

		if (arr == null) {
			return;
		}
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int N = 20;
		int[] arr = generateArray(N); 
		printArray(arr);
		int[] indexs = partition(arr, 0, arr.length-1, N/6);
		System.out.println(N/6);
		printArray(arr);
	}
	
}

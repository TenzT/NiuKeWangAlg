package CH02;

/**
 * 
 * @author tandezhi
 * 利用荷兰国旗问题优化快排
 */

public class NetherlandsQuickSort {
	private static int[] partition(int[] arr, int low, int high) {
		int less = low - 1;	 // index小于等于less的都小于p
		int more = high;	// index大于等于more的都小于p 最后一位作为pivot
		while (low < more) {
			if (arr[low] < arr[high]) swap(arr, low++, ++less);	// 先多拿一个位置再交换
			else if (arr[low] > arr[high]) swap(arr, low, --more);	
			else low++;
		}
		swap(arr, more, high);		// 这里每一个arr[high]都是pivot,要和more调换，即将最后一位搬回到 =p 的区域
		
		return new int[] {less+1, more};
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if(low >= high) return;
		int[] indexes = partition(arr, low, high);
		quickSort(arr, low, indexes[0]-1);
		quickSort(arr, indexes[1]+1, high);
	}
	
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static int[] generateArray(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (N+1));
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
		int N = 10;
		int[] arr = generateArray(N);
//		arr = new int[]{9,7,3,23,5,6,3};
		printArray(arr);
		
		quickSort(arr);
		printArray(arr);
	}
}

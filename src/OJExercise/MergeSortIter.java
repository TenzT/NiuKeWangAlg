package OJExercise;

/*
 * 使用遍历的方式完成归并排序
 */
public class MergeSortIter {
	public static int[] aux;	// 辅助用数组
	
	public static void sortIter(int[] arr) {
		aux = new int[arr.length];
		for(int sz=1;sz<arr.length;sz = 2*sz)
			for(int lo=0;lo<arr.length-sz;lo+=2*sz)
				merge(arr, lo, lo+sz-1, Math.min(lo+2*sz-1, arr.length-1)); // 需要抠边界的是high的取值
	}
	
	public static void merge(int[] a, int low, int mid, int high) {
		int pLeft = low;
		int pRight = mid+1;
		int pA = low;
		
		for (int k=low;k<=high;k++) {
			aux[k] = a[k];
		}
		
		while(pLeft<=mid && pRight<=high) {
			if(aux[pLeft]<aux[pRight]) {
				a[pA++] = aux[pLeft++];
			} else {
				a[pA++] = aux[pRight++];
			}
		}
		
		while(pLeft<=mid) {
			a[pA++] = aux[pLeft++];
		}
		
		while(pRight<=high) {
			a[pA++] = aux[pRight++];
		}
	}
	
	public static void main(String[] args) {
//		String[] a = "S O R T E X A M P L E".split(" ");
//		int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] a = new int[]{2, 4, 3, 7, 5};
		sortIter(a);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}
	
}

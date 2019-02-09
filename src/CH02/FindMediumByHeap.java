package CH02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * 使用堆来找数据流中的中位数
 */
public class FindMediumByHeap {
	private static PriorityQueue<Integer> maxHeap;	// 最大堆存放比中位数小的数
	private static PriorityQueue<Integer> minHeap;	// 最小堆存放比中位数大的数
	
	private static int[] generateArray(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (N+1));
		}
		return arr;
	}
	
	private static void printArray(int[] arr) {

		if (arr == null) {
			return;
		}
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	
	private static double findMedium(int[] arr) {
		minHeap = new PriorityQueue<>();	
		maxHeap = new PriorityQueue<>(arr.length, new ComparatorBigHeap());
		
		for (int n : arr) {
			
			// 当堆为空时先插入堆
			if(maxHeap.isEmpty()) {
				maxHeap.add(n);
				continue;
			} else if(minHeap.isEmpty()) {
				minHeap.add(n);
				continue;
			}
			
			
			// 调整 less 和 more 的边界, 处理less大于more的情况,交换一下边界好了
			if(maxHeap.peek() > minHeap.peek()) {
				int tmp = minHeap.remove();
				minHeap.add(maxHeap.remove());
				maxHeap.add(tmp);
			}
			
			if(n <= maxHeap.peek()) {
				maxHeap.add(n);
			} else {
				minHeap.add(n);
			}
			
			// 调整两堆的平衡
			if(maxHeap.size()-minHeap.size() >= 2) {
				minHeap.add(maxHeap.remove());
			} else if (minHeap.size()-maxHeap.size() >= 2) {
				maxHeap.add(minHeap.remove());
			}
		}
		
		// 存放完毕
		if(maxHeap.size() > minHeap.size()) { // 小于中位数的多
			return maxHeap.remove();
		} else if(minHeap.size() > maxHeap.size()) { // 大于等于中位数的多
			return minHeap.remove();
		} else {
			return ((float)minHeap.remove() + (float)maxHeap.remove())/2;
		}
	}
	
	public static void main(String[] args) {
		int N = 21;
		int[] arr = generateArray(N);
//		int[] arr = new int[]{3, 1, 20, 16, 7, 18, 14, 9, 15, 9, 2, 17, 7, 1, 9, 10, 14, 5, 8, 5 };
		printArray(arr);
		
		System.out.println(findMedium(arr));

		System.out.println("正确答案，在排序后的数组中查找");
		Arrays.sort(arr);
		printArray(arr);
		
		if(N%2 == 0) 
			System.out.println(((float)arr[N/2] + (float)arr[N/2-1])/2);
		else {
			System.out.println((float)arr[N/2]);
		}
	}
}


class ComparatorBigHeap implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}
	
}
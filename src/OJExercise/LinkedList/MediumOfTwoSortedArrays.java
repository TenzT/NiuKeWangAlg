package OJExercise.LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找到两个有序数组的中位数
 */
public class MediumOfTwoSortedArrays {
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
	
	//法1:数据流中找中位数，并没有利用有序数组这个特征，创建一个大顶堆一个小顶堆，大顶堆维护比中位数小的数，小顶堆维护比中位数大的数，维护两个堆的元素个数差小于等于1，最后在结果能在堆顶中找到
	//这种方法的时间复杂度是O(m+n),空间复杂度是O(m+n)
	private static double findMedianSortedArrays1(int[] A, int[] B) {
		// 最小堆存放比中位数大的数
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();	 
		// 最大堆存放比中位数小的数
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(A.length+B.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		for (int n : A) {
			
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
		
		for (int n : B) {
			
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
	
	// 法2:两个数组的长度已知，转化成找第k小个数的问题，考虑
	
}

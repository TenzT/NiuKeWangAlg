package OJExercise.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * 有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 * 注意是可放回的
 */
public class PairsMaxMin {

	public static int[] pairMaxMin(int[] arr) {
		if (arr == null) {
			return null;
		}
		
		Arrays.sort(arr);
		int len = arr.length;
		
		// 所有数都相等
		if (arr[0] == arr[len-1]) {
			return new int[]{0, (len*(len-1))/2};	// 组合
		}
		
		//map用来统计
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i=0;i<len;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }
        
        // 求差最小对数，如果数组中有重复数字则是0，遍历一遍map找到所有数组个数不为0的数字会产生最小差0，利用公式计算
        // 如果数组中没有重复数字，只能遍历一遍数组来统计了
        int countMin = 0;
        if (map.size() == len) {	// 没有重复数字,只好统计一遍
        	int min = Math.abs(arr[1] - arr[0]);
        	for (int i=2; i< len; i++) {
        		int tmp = Math.abs(arr[i]-arr[i-1]);
        		if (tmp == min) {
        			countMin++;
        		} else if (tmp < min) {
        			min = tmp;
        			countMin = 1;
        		}
        	}
        } else {	// 有重复数字则遍历map
        	for (Integer key : map.keySet()) {
        		if (map.get(key) > 1) {
        			countMin += map.get(key) / 2;	// 两两组合
        		}
        	}
        }
        
		// 统计最大差对数
        int countMax = 0;
        List<Integer> keySet = new ArrayList<>(map.keySet());
        int val1 = map.get(keySet.get(0));	// 统计所有最小值的个数
        int val2 = map.get(keySet.get(keySet.size()-1));	// 统计所有最大值的个数
        countMax = val1 * val2;
        
        
		return new int[]{countMin, countMax};
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = in.nextInt();
		}
		int[] res = pairMaxMin(arr);
		System.out.println(res[0] + " " + res[1]);

	}
}
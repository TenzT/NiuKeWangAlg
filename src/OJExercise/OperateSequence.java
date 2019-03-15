package OJExercise;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。 
 * 
 * testcase：
 * 4
 * 1 2 3 4
 * 输出：
 * 4 2 1 3
 */
public class OperateSequence {
	public static void operate1(long[] arr) {
		if (arr == null) {
			return;
		}
        LinkedList<Long> listB = new LinkedList<>();
        for (int i=0; i < arr.length; i++) {
            listB.add(arr[i]);
            Collections.reverse(listB);
        }
        for (Long l : listB) {
            System.out.print(l + " ");
        }
    }
	
	// 头尾插入
	public static void operate2(long[] arr) {
		if (arr == null) {
			return;
		}
        LinkedList<Long> listB = new LinkedList<>();
        for (int i=0; i < arr.length; i++) {
        	if (i % 2==0) {	// 偶数尾插入
        		listB.addLast(arr[i]);
        	} else {	// 奇数头插入
        		listB.addFirst(arr[i]);
        	}
        }
        if (arr.length % 2 == 1) {
        	Collections.reverse(listB);
        }
        
        for (Long l : listB) {
            System.out.print(l + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        long[] arr = new long[len];
        for (int i=0; i < len; i++) {
            arr[i] = in.nextLong();
        }
        operate1(arr);
        System.out.println();
        operate2(arr);
    }
}

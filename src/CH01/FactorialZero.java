package CH01;

import java.util.Scanner;

/**
 * 
 * @author tandezhi
 * 编程之美P125
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2 
 * 输入: 输入为一行，n(1 ≤ n ≤ 1000)	输出: 输出一个整数,即题目所求
 * 尝试过的思路：
 * 1. 用递归来做，会栈溢出
 * 2. 问题1用迭代来完成，但是数即使变成long了仍会溢出
 * 3. 0由5和偶数相乘而得。用n/5统计0到n中上有多少个5的整数倍，对这些数做质因数分解。比如5=5*1(1个零) 25=5*5(2个0) 125=25*5=5*5*5(3个零)
 * 提取思想：统计有多少个结尾是多少的数的题目，用质因数分解的思想
 * 启示：证明m是n的整数倍 if(m % n==0)
 */

public class FactorialZero {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int count = 0;
		for(int i=1;i<=num;i++) {
			int j = i;
			// 统计当前j是5的几次幂  
			while(j % 5 == 0) {
				count++;
				j /= 5;
			}
		}
		// 综合上面的可以知道，最后的count = [N/5] + [N/25] + [N/125] + ...
	
		System.out.println(count);
	}
}

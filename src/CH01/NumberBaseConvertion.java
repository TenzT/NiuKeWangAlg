package CH01;

import java.util.Scanner;

/**
 * 
 * @author tandezhi
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数 
 * 输入描述:输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 * 输出描述:为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 * e.g. 输入 7 2  输出 111
 */

public class NumberBaseConvertion {
	private static String[] baseChar = new String[]{
			"0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "A", "B", "C", "D", "E", "F"};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int base = in.nextInt();
		boolean negetive  = false;	// 由于后面余数会作为索引，因此需要保证是非负数
		
		// 保护性代码 
		if (base < 2 || base>16) return;
		
		if (num < 0) {
			negetive = true;
			num = -num;
		}
		
		StringBuilder res = new StringBuilder();
		
		while(num != 0) {
			int remainder = num % base;
			num /= base;
			res.insert(0, baseChar[remainder]);
		}
		
		System.out.println(negetive ? ("-" + res) : res);
	}
}

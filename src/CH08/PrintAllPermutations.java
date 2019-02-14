package CH08;

import java.util.HashSet;

public class PrintAllPermutations {
	/**
	 * 打印一个字符串的全部排列
	 * @param string
	 */
	public static void printAllPermutations1(String string) {
		char[] chs = string.toCharArray();
		printAllPermutations1(chs, 0);
	}
	private static void printAllPermutations1(char[] chs, int cur) {
		if(cur == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		for (int i=cur; i < chs.length; i++) {
			swap(chs, i, cur);
			printAllPermutations1(chs, cur+1);
		}
		
	}
	private static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	
	// 在上面的基础上滤除重复的结果
	public static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		printAllPermutations2(chs, 0);
	}

	private static void printAllPermutations2(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<>();
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				printAllPermutations2(chs, i + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		printAllPermutations1("abc");
		System.out.println("======");
		printAllPermutations2("abc");
		System.out.println("======");
		
	}
}

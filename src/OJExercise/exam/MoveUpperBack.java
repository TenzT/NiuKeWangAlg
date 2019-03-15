package OJExercise.exam;

import java.util.Scanner;

/*
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 */
public class MoveUpperBack {
	
	public static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	// 这里出现过一个问题，涉及数组指针的，如果有遍历结束条件，要放到逻辑判断的最前面
	public static String moveUpperBack(String target) {
		if (target == null || target.length()==0) {
			return null;
		}
		char[] chars = target.toCharArray();
		for (int i = chars.length-1; i >= 0; i--) {
			if (chars[i] >= 'A' && chars[i] <= 'Z') {	// 如果是大写字母
				if (i == chars.length-1) {
					continue;
				}
				int j = i;
				while (j < chars.length-1 && chars[j+1] >= 'a' && chars[j+1] <= 'z' ) {
					swap(chars, j, j+1);
					j++;
				}
			}
		}
		
		return new String(chars);
	}
	
	
	// 法2：使用正则表达式，将前面所有大写字母变空append上小写字母变空
	public static String moveUpperBack2(String str) {
		return str.replaceAll("[A-Z]","")+str.replaceAll("[a-z]","");
	}
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		String target = in.nextLine();
		while (in.hasNextLine()) {
			String target = in.nextLine();
			System.out.println(moveUpperBack(target));
			System.out.println(moveUpperBack2(target));
		}
		
	}
}

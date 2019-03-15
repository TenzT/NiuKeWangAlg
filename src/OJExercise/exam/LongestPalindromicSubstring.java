package OJExercise.exam;

import java.util.Scanner;
import java.util.Stack;

/*
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 */
public class LongestPalindromicSubstring {
	
	// 思路：使用动态规划，求原字符串和其反串的最大公共子序列，再用原字串长度减去最后的长度
	public static String lcsDP(String X, String Y) {
		char[] s1 = X.toCharArray();
		char[] s2 = Y.toCharArray();
		int[][] dp = new int[X.length()+1][Y.length()+1];	// dp表，表示最长子串的长度，也是状态转移的关键
		
		// 设置basecase
		for (int j=0; j < dp[0].length; j++) {
			dp[0][j] = 0;
		}
		for (int i=0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		
		for (int m=1; m < dp.length; m++) {
			for (int n=1; n < dp[m].length; n++) {	// 最大子串也只能到m
				if (s1[m-1] == s2[n-1])	{
					dp[m][n] = dp[m-1][n-1] + 1;	// 递推关系1
				} else {
					dp[m][n] = Math.max(dp[m-1][n], dp[m][n-1]);	// 递推关系2
				}
			}
		}
		
		//
		Stack<Character> stack = new Stack<>();
		int i = X.length() - 1;
		int j = Y.length() - 1;
		
		while((i >= 0) && (j >= 0)){
			if(s1[i] == s2[j]){//字符串从后开始遍历，如若相等，则存入栈中
				stack.push(s1[i]);
				i--;
				j--;
			}else{
				if(dp[i+1][j] > dp[i][j+1]){//如果字符串的字符不同，则在数组中找相同的字符，注意：数组的行列要比字符串中字符的个数大1，因此i和j要各加1
					j--;
				}else{
					i--;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()){//打印输出栈正好是正向输出最大的公共子序列
			sb.append(stack.pop());
		}	
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String target = in.nextLine();
			String res = lcsDP(target, new StringBuffer(target).reverse().toString());
			System.out.println(target.length() - res.length());
		}
	}
}

package OJExercise.DynamicProgramming;

import java.util.Scanner;
import java.util.Stack;

/*
 * 给定两个序列X和Y，求X和Y长度最长的公共子序列
 */
public class LongestCommonSubsequence {
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
	
	/*
	 * test case
	 * ABCBDAB
	 * BDCABA
	 * 输出BCBA
	 * 
	 * 10010101
	 * 010110110
	 * 输出100110
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String X = in.nextLine();
			String Y = in.nextLine();
			System.out.println(lcsDP(X, Y));
		}
		
	}
}

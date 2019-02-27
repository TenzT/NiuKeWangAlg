package OJExercise.DynamicProgramming;

import java.util.Scanner;

/* 向前递推
 * 要求的是n条折线分割平面的最大数目
 * 思路:先从直线分割平面出发，得到规律是2N
 * 如果把每两条直线的一个端点相交，就变成一条直线，被分割的区域就减少2，
 * 则 f(n)=f(n-1)+4*(n-1)+1,n>=3 f(1) = 2, f(2) = 7
 */
public class DevidingPlane {
	public static int cutting(int n) {
		if (n==1) {
			return 2;
		}
		if (n==2) {
			return 7;
		}
		
		int[] dp = new int[1000];
		dp[1] = 2;
		dp[2] = 7;
		for (int i=3; i <=n; i++) {
			dp[i] = dp[i-1] + 4*dp[i-1] + 1;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			System.out.println(cutting(n));
		}
	}
}

package OJExercise.exam;

import java.util.Scanner;

/*考虑仅用1分、5分、10分、25分和50分这5种硬币支付某一个给定的金额。例如需要支付11分钱，
 * 有一个1分和一个10分、一个1分和两个5分、六个1分和一个5分、十一个1分这4种方式。请写
 * 一个程序，计算一个给定的金额有几种支付方式。
 * 注：假定支付0元有1种方式
 * PS：这题与跳台阶不同，跳台阶是排列问题，这里是组合问题，组合问题的经典案例是背包问题
 * 总体思路：可以看成能够重复取元素的背包问题,即多重背包问题的方案数
 */
public class CoinsWay {
	public static long count1(int maxValue, int aim) {
//		int[] money = new int[maxValue];
//		for (int i=0; i< maxValue; i++) {
//			money[i] = i+1;
//		}
		return process1(aim, 1, maxValue);
	}
	public static long process1(long aim, long cur, long maxValue) {
		int res = 0;	// 方法数
		if (cur == maxValue) {	// cur到了最后了，还不能整减aim，说明这条路不行
			res = (aim-cur) == 0 ? 1 : Integer.MAX_VALUE;
		} else {
			for (int i=1; cur*i <= aim; i++) {
				int tmp = (int)process1(aim-cur*i, cur+1, maxValue);
				if ()
				res += ;
			}
		}
		return res;
	}
	
	// dp版本，二维数组
	public static int count2(int aim) {
		int[] money = new int[]{1, 5, 10, 25, 50};
		int[][] dp = new int[money.length+1][aim+1];
		// basecase
		for (int i = 0; i <money.length; i++) {
			dp[i][0] = 1;
		}
		for (int j=1; money[0]*j <= aim; j++) {
			dp[0][money[0]*j] = 1;
		}
		
		int num = 0;
		for (int i=1; i < money.length; i++) {
			for (int j=1; j <= aim; j++) {
				num = 0;
				for (int k=0; j-money[i]*k >=0; k++) {;
					num += dp[i-1][j-money[i]*k];
				}
				dp[i][j] = num;
			}
		}
		return dp[money.length-1][aim];
	}
	
	// dp版本，一维数组优化的版本
	public static long count3(int maxValue, int target) {
		if (target <= 0) {
            return 1;
        }
		long[] dp = new long[target+1];
		dp[0] = 1;
		for (int i=1; i <= Math.min(maxValue, target); i++) {
			for (int j=i; j<=target; j++) {
				dp[j] = dp[j] + dp[j - i];
			}
		}
		
		return dp[target];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
        	int maxValue = in.nextInt();
        	int target = in.nextInt();
            System.out.println(count1(maxValue, target));
        }
	}
}

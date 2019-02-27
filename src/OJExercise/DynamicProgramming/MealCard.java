package OJExercise.DynamicProgramming;
/*
 * 0-1背包问题
 * 在购买之前判断余额，如果购买一个商品之前，
 * 卡上的剩余金额大于或等于5元，就一定可以购买成功（即使购买后卡上余额为负），
 * 否则无法购买（即使金额足够）。所以大家都希望尽量使卡上的余额最少。
 * 输入： 第一行为正整数n，表示菜的数量。n<=1000。
 * 		第二行包括n个正整数，表示每种菜的价格。价格不超过50。
 * 		第三行包括一个正整数m，表示卡上的余额。m<=1000。
 * 输出：卡上可能的最小余额
 */
import java.util.Scanner;

public class MealCard {
	
	// 暴力递归
	public static int minValue1(int[] price, int balance) {
		return process1(price, 0, balance);
	}
	public static int process1(int[] price, int cur, int balance) {
		if(cur == price.length) {
			return balance;
		}
		// 扣钱之前先检查
		if (balance < 5) {
			return balance;
		}
		// 买了这个菜的结果
		int resInclude = process1(price, cur+1, balance - price[cur]);
		// 不买了这个菜的结果
		int resReclude = process1(price, cur+1, balance);
		return Math.min(resInclude, resReclude);
	}
//	
//	// dp版本
//	public static int minValue2(int[] price, int balance) {
//		if (price == null) {
//			return balance;
//		}
//		int[][]dp = new int[price.length+1][balance+1];	// dp二维数组
//		// basecase都是0，所以不管
//		for (int i = price.length-1; i >= 0; i--) {
//			for (int j = balance; j >= 0; j--) {
//				dp[i][j] = dp[i+1][j];	// 不拿这个物件的情况
//				if (j + weights[i] <= volumn) {	// 拿这个物件的情况
//					dp[i][j] = Math.max(
//							values[i] + dp[i+1][j + weights[i]], 
//							dp[i][j]);
//				}
//			}
//		}
//		
//		return dp[0][0];
//	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int[] price = new int[number];
		for (int i=0; i< price.length; i++) {
			price[i] = in.nextInt();
		}
		int volumn = in.nextInt();
		/*
		 * 测试用例
		 * 1
		 * 50
		 * 5
		 * 答案是-45
		 * 
		 * 10
		 * 1 2 3 2 1 1 2 3 2 1
		 * 50  
		 * 答案是32
		 */
		System.out.println(minValue1(price, volumn));
//		System.out.println(maxValue2(weights, values, volumn));
		
	}
}

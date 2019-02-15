package CH08;

/*背包问题
 * 给定两个数组w和v， 两个数组长度相等， w[i]表示第i件商品的
 * 重量， v[i]表示第i件商品的价值。 再给定一个整数bag， 要求
 * 你挑选商品的重量加起来一定不能超 过bag， 返回满足这个条件
 * 下， 你能获得的最大价值
 */
public class Knapsack {
	// 暴力递归版本
	public static int maxValue1(int[] weights, int[] values, int bag) {
		return process1(weights, values, 0, 0, bag);
	}
	private static int process1(int[] weights, int[] values, int cur, int sumWeight, int bag) {
		// 不能越界
		if (cur == weights.length) {
			return 0;
		}
		// 看看这一步能不能取
		if (sumWeight+weights[cur] > bag) {	// 如果加上这个值就超重的话，那还是不用加了
			return 0;
		}
		// 能取的话就递归传递下去看看结果
		int resInclude = values[cur] + process1(weights, values, cur+1, sumWeight + weights[cur], bag); 	// 要当前的
		int resExclude = process1(weights, values, cur+1, sumWeight, bag); 	// 不要当前的
		
		return Math.max(resInclude, resExclude);
	}
	
	
	public static int maxValue2(int[] weights, int[] values, int bag) {
		int[][] dp = new int[weights.length+1][bag+1];
		for (int i=weights.length-1; i >= 0; i--) {	// basecase为最后一行，等于0
			for (int j=bag; j >= 0; j--) {
				dp[i][j] = dp[i+1][j];
				if(j + weights[i]<=bag) {
					dp[i][j] = Math.max(dp[i][j], 
							values[i] + dp[i+1][j + weights[i]]);
				}
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[] weights = { 10, 2, 4, 7 };
		int[] values = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue1(weights, values, bag));
		System.out.println(maxValue2(weights, values, bag));
		
		weights = new int[]{3, 4, 5};
		values = new int[]{5, 4, 6};
		bag = 10;
		System.out.println(maxValue1(weights, values, bag));
		System.out.println(maxValue2(weights, values, bag));
		
		weights = new int[]{0};
		values = new int[]{0};
		bag = 10;
		System.out.println(maxValue1(weights, values, bag));
		System.out.println(maxValue2(weights, values, bag));
	}
}

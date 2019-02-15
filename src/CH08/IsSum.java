package CH08;

/*
 * 给你一个数组arr， 和一个整数aim。 如果可以任意选择arr中的
 * 数字， 能不能累加得到aim， 返回true或者false
 */
public class IsSum {
	// 暴力递归版本
	public static boolean isSum1(int[] arr, int aim) {
		return isSum1(arr, 0, 0, aim);
	}
	private static boolean isSum1(int[] arr, int cur, int sum, int aim) {
		if (sum == aim) {	// basecase
			return true;
		}
		if (cur == arr.length) {
			return false;
		}
		
		return isSum1(arr, cur+1, sum, aim) || isSum1(arr, cur+1, sum+arr[cur], aim);
	}
	
	// 动态规划版本
	public static boolean isSum2(int[] arr, int aim) {
		// 创建dp表,dp表的作用就是记录中间状态
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];	// 不同行代表不同位(对应暴力递归的cur)，
														// 不同列代表0到aim的情况（对应暴力递归的sum）
		// 设置basecase
		for (int i=0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i=arr.length-1; i >= 0; i--) {
			for (int j = aim-1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];	// 不加上i这个数时的结果
				if (j + arr[i] <= aim) {	// 加上i这个数时的结果，sum变成j+arr[i]
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];	// 只要有一个true即可,填表的语句对应的就是状态转移的语句
				}
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		System.out.println(isSum1(arr, aim));
		System.out.println(isSum2(arr, aim));
	}
}

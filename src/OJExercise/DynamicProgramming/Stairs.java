package OJExercise.DynamicProgramming;

/*
 * 有一楼梯共M级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第M级，共有多少种走法？
 */
public class Stairs {
	public static int stairs(int M) {
		if (M==1 || M ==2) {
			return 1;
		}
		int[] dp = new int[M+1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i=3; i<=M; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[M];
	}
	
}

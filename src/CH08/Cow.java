package CH08;

/* 母牛每年生一只母牛， 新出生的母牛成长三年后也能每年生一只母牛， 
 * 假设牛不会死。 求N年后，母牛的数量
 */
public class Cow {
	
	// 暴力迭代的版本
	public static int cowNumber1(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		return cowNumber1(n-1) + cowNumber1(n-3);
	}
	
	// 动态规划的版本
	public static int cowNumber2(int n) {
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[] res = new int[n+1];
		res[0] = 0;
		res[1] = 1;
		res[2] = 2;
		res[3] = 3;
		for(int i = 4; i <= n; i++) {
			res[i] = res[i-1] + res[i-3];
		}
		return res[n];
	}
	
	
	public static void main(String[] args) {
		System.out.println(cowNumber1(20));
		System.out.println(cowNumber2(20));
	}
}

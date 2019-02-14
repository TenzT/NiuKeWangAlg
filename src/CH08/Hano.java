package CH08;

public class Hano {
	/**
	 * 汉诺塔游戏
	 * @param N ： 代表目前是1到N的问题
	 * @param from ：最左边的杆
	 * @param to ： 最右边的杆
	 * @param help ： 中间的辅助杆
	 */
	public static void process(int N, String from, String to, String help) {
		if (N == 1) {
			System.out.println("Move 1 from " + from + " to " + to);
		} else {
			process(N - 1, from, help, to);	// 将 1 ～ N-1 搬到help上面
			System.out.println("Move " + N + " from " + from + " to " + to);
			process(N - 1, help, to, from);	// 将 1 ~ N-1 从help搬到to上
		}
	}
	public static void main(String[] args) {
		int n = 3;
		process(n, "左", "右", "中");
	}
}

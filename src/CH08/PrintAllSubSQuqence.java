package CH08;

/*
 * 打印一个字符串的全部子序列， 包括空字符串
 */
// 暴力递归
public class PrintAllSubSQuqence {
	public static void printAllSubsquence(String string) {
		String res = "";
		char[] chs = string.toCharArray();
		printAllSubsquence(chs, 0, res);
	}
	private static void printAllSubsquence(char[] chs, int cur, String res) {
		if(cur == chs.length) {
			System.out.println(res);
			return;
		}
		printAllSubsquence(chs, cur+1, res);
		printAllSubsquence(chs, cur+1, res + String.valueOf(chs[cur]));
	}
	
	public static void main(String[] args) {
		printAllSubsquence("abc");
	}
}

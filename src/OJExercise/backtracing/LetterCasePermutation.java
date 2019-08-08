package OJExercise.backtracing;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class LetterCasePermutation {

	// 结果
	private List<String> resList = new ArrayList<String>();
	
	// trace
	private StringBuilder trace = new StringBuilder();
	
	public List<String> letterCasePermutation(String S) {
		char[] charArray = S.toCharArray();
		dfs(charArray, 0);
		return resList;
    }
	
	private void dfs(char[] charArray, int cur) {
		if (cur == charArray.length) {
			resList.add(trace.toString());
			return;
		}
		
		if (Character.isDigit(charArray[cur])) {
			trace.append(charArray[cur]);
			dfs(charArray, cur+1);
			trace.deleteCharAt(trace.length()-1);
		} else {
			// 小写
			trace.append(Character.toLowerCase(charArray[cur]));
			dfs(charArray, cur+1);
			trace.deleteCharAt(trace.length()-1);
			
			// 大写
			trace.append(Character.toUpperCase(charArray[cur]));
			dfs(charArray, cur+1);
			trace.deleteCharAt(trace.length()-1);
		}
	}
	
	public static void main(String[] args) {
		LetterCasePermutation obj = new LetterCasePermutation();
		String S = "a1b2";
		List<String> list = obj.letterCasePermutation(S);
		System.out.println(list);
	}
	
}

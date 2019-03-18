package OJExercise.dfs;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a string S, we can transform every letter individually 
 * to be lowercase or uppercase to create another string.  Return 
 * a list of all possible strings we could create.
 * 
 * 全部AC
 */
public class LetterCasePermutation {
	public static List<String> letterCasePermutation(String S) {
        List<String> result = new LinkedList<>();
        StringBuffer path = new StringBuffer(); 
        char[] chars = S.toCharArray();
        dfs(chars, 0, path, result);
        return result;
    }
	
	public static void dfs(char[] chars, int index, StringBuffer path, List<String> result) {
		if (index == chars.length) {
			result.add(path.toString());
			return;
		}
		
		// 属于数字则直接往下传
		if (Character.isDigit(chars[index])) {
			path.append(chars[index]);
			dfs(chars, index+1, path, result);
			path.deleteCharAt(path.length()-1);
		} else {
			// 加入大写
			path.append(Character.toUpperCase(chars[index]));
			dfs(chars, index+1, path, result);
			path.deleteCharAt(path.length()-1);
			
			// 加入小写
			path.append(Character.toLowerCase(chars[index]));
			dfs(chars, index+1, path, result);
			path.deleteCharAt(path.length()-1);
		}
	}
	
	public static void main(String[] args) {
		String S = "a1b2";
		List<String> result = letterCasePermutation(S);
		for (String s:result) {
			System.out.println(s);
		}
	}
}

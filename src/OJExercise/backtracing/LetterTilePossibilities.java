package OJExercise.backtracing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * 给定一个字符串，返回你可以引出的所有非空字母序列的数目
 */
public class LetterTilePossibilities {

	// res
	private List<String> resList = new LinkedList<String>();
	
	// trace
	private StringBuilder trace = new StringBuilder();
	
	// visited
	private Set<Integer> visitedIndex = new HashSet<Integer>();
	
	public int numTilePossibilities(String S) {
		char[] charArray = S.toCharArray();
		Arrays.sort(charArray);
		dfs(charArray);
		return resList.size();
	}
	
	
	private void dfs(char[] charArray) {
		
		for (int i=0; i<charArray.length; i++) {
			if (i>0 && charArray[i]==charArray[i-1] && !visitedIndex.contains(i-1)) {
				continue;
			}
			
			if (!visitedIndex.contains(i)) {	
				trace.append(charArray[i]);
				visitedIndex.add(i);
				// 收割结果
				resList.add(trace.toString());
				
				// 回溯
				dfs(charArray);
				
				trace.deleteCharAt(trace.length()-1);
				visitedIndex.remove(i);
			}
			
		}
	}
	
	public static void main(String[] args) {
		LetterTilePossibilities obj = new LetterTilePossibilities();
//		List<String> res = obj.numTilePossibilities("AAAB");
//		System.out.println(res);
		System.out.println(obj.numTilePossibilities("AAAB"));
		
	}
}

package OJExercise.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {
	// 思路，把左括号看成1，右括号看成2，那问题则变成了有重复1和重复2的全排列生成,而另一个剪枝条件是组成的括号需要有效
	List<String> resList = new ArrayList<String>();
	
	// 已经访问的坐标
	private Set<Integer> visitedIndex = new HashSet<Integer>();
	
	// trace
	StringBuilder trace = new StringBuilder();
	
	public List<String> generateParenthesis(int n) {
		char[] input = new char[2*n];
		for (int i=0; i<n; i++) {
			input[i] = '(';
		}
		for (int i=n; i<2*n; i++) {
			input[i] = ')';
		}
		
		dfs(input);
		
		return resList;
    }
	
	public boolean valid() {
		Stack<Character> stack = new Stack<Character>();
		for (int i=0; i<trace.length(); i++) {
			char tmp = trace.charAt(i);
			if (stack.isEmpty()) {
				stack.push(tmp);
			} else if ((stack.peek() == '(' && tmp==')')) {
				stack.pop();
			} else {
				stack.push(tmp);
			}
		}
		
		return stack.isEmpty();
	}
	
	private void dfs(char[] input) {
		// 收割结果
		if (trace.length() == input.length) {
			if (valid()) {
				resList.add(trace.toString());
			}
			return;
		}
		for (int i=0; i < input.length; i++) {
			// 跳过重复元素，visitedIndex.contains(i-1)的条件是说明对除了第一个元素以外的集合做permutation
			if (i > 0 && input[i] == input[i - 1] && !visitedIndex.contains(i - 1)) {
                continue;
            }
			
			// 回溯法
			if (!visitedIndex.contains(i)) {	// 未用来构建序列
				visitedIndex.add(i);
				trace.append(input[i]);
				dfs(input);
				trace.deleteCharAt(trace.length()-1);	
				visitedIndex.remove(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		GenerateParenthesis obj = new GenerateParenthesis();
		List<String> list = obj.generateParenthesis(3);
		System.out.println(list);
	}

}

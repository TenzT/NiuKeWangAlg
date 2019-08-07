package OJExercise.bruteforce;

import java.util.ArrayList;
import java.util.List;

/*
 * s素数环： 输入正整数n，把1，2，3....n组成一个环，使得相邻两个整数之和均为素数，输出时从整数1开始逆时针排列
 */
public class PrimeLoop {
	// 思路：带剪枝的全排列
	
	// 结果队列
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();
	
	// trace
	private List<Integer> trace = new ArrayList<Integer>();
	
	
	private void dfs(int n) {
		if (trace.size() == n) {
			if (isPrime(trace.get(0) + trace.get(trace.size()-1))) {
				resList.add(new ArrayList<Integer>(trace));
			}
			return;
		}
		
		for (int i = 2; i<=n; i++) {
			if (!trace.contains(i) && isPrime(trace.get(trace.size()-1)+i)) {
				trace.add(i);
				dfs(n);
				trace.remove(trace.size()-1);
			}
		}
	}
	
	private boolean isPrime(int num) {
		for (int i=2; i<= num; i++) {
			if (num % i ==0 && i != num) {
				return false;
			} else if (i == num) {
				return true;
			}
		}
		return false;
	}
	

	public List<List<Integer>> primeLoop(int n) {
		trace.add(1);
		dfs(n);
		return resList;
	}
	
	public static void main(String[] args) {
		PrimeLoop obj = new PrimeLoop();
		
		List<List<Integer>> res = obj.primeLoop(4);
		
		for (List<Integer> r : res) {
			System.out.println(r);
		}
		
	}
	
}

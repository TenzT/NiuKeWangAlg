package OJExercise.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 给定一个集合(里面都是不同的数字)，返回所有可能的子集
 * 要求：
 * 1. 子集中的元素是非递减的
 * 2. 整个结果集合，不能有相同的子集
 */
public class Subsets {
	// 增量构造法+DFS：用指针指向元素，每个元素都有两种选择，选或者不选
	// 时间复杂度(2^n)，空间复杂度O(n)
	// 关键点：画出递归树就理解了
	public static void process1(int[] set, int cur, LinkedList<LinkedList<Integer>> result, LinkedList<Integer> path) {
		if (cur == set.length) {	// 递归树木的底, 把路径装进去
			result.add(new LinkedList<>(path));
			return;
		}

		// 走这条路，则new一个path下去
//		LinkedList<Integer> pathThis = new LinkedList<>(path);
//		pathThis.add(set[cur]);
//		process1(set, cur+1, result, pathThis);
		
		// 更加dfs的写法
		path.add(set[cur]);
		process1(set, cur+1, result, path);
		path.remove(path.size()-1);
		
		// 不选当前这个元素, 直接往下走
		process1(set, cur+1, result, path);
		
	}
	public static LinkedList<LinkedList<Integer>> subsets1(int[] set) {
		LinkedList<LinkedList<Integer>> result = new LinkedList<>();
		Arrays.sort(set);	// 对集合进行排序
		LinkedList<Integer> path = new LinkedList<>();
		process1(set, 0, result, path);
		return result;
	}
	
	
	
	// 位向量法,每条路径"好像"有自己的bitmap，而不是遇到新选择就开一条路径下去，在树根才装数据
	// 为什么说好像，因为一直都只有一个，只是靠DFS回溯改变了
	public static void process2(int[] set, int cur, LinkedList<LinkedList<Integer>> result, boolean[] selected) {
		if (cur == set.length) {	// 递归树的底,
			LinkedList<Integer> path = new LinkedList<>();
			for (int i=0; i < set.length; i++) {
				if (selected[i] == true) path.add(set[i]);
			}
			result.add(path);
			return;
		}

		// 走这条路，则将位图点true
		selected[cur] = true;
		process2(set, cur+1, result, selected);
		
		// 不选当前这个元素, 直接往下走
		selected[cur] = false;
		process2(set, cur+1, result, selected);
		
	}
	public static LinkedList<LinkedList<Integer>> subsets2(int[] set) {
		LinkedList<LinkedList<Integer>> result = new LinkedList<>();
		Arrays.sort(set);	// 对集合进行排序
		boolean[] selected = new boolean[set.length];
		process2(set, 0, result, selected);
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] set = new int[num];
		for (int i=0; i< num; i++) {
			set[i] = in.nextInt();
		}
		LinkedList<LinkedList<Integer>> result;
		result = subsets1(set);
//		result = subsets2(set);
		while (!result.isEmpty()) {
			LinkedList<Integer> tmp = result.removeFirst();
			if (tmp!=null) {
				for (Integer n : tmp) {
					System.out.print(n + " ");
				}
				System.out.println();
			}
		}
	}
}

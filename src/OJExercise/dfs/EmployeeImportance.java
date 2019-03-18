package OJExercise.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * leetcode 690
 * 全部AC
 */
public class EmployeeImportance {
	public static class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	
	public static int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		
		return dfs(map, map.get(id));
    }
	
	public static int dfs(Map<Integer, Employee> map, Employee employee) {
		
		int importance = employee.importance;
		for (int i : employee.subordinates) {
			importance += dfs(map, map.get(i));
		}
		return importance;
	}
}

package OJExercise;
/*
 * 检查给定字符串是不是回文的
 */

public class Palindrome {
	public static boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        s = s.toLowerCase();    // 忽略大小写
        s = s.replaceAll("[^a-zA-Z0-9]", "");    // 只保留字符
        char[] chs = s.toCharArray();
        return isPalindrome(chs, 0);
    }
    
    public static boolean isPalindrome(char[] chs, int cur) {
        if (cur == chs.length) {
            return true;
        }
        return chs[cur] == chs[chs.length-1-cur] && isPalindrome(chs, cur+1);
    }
    
    public static void main(String[] args) {
		System.out.println(isPalindrome("aAb,BaA"));
		System.out.println(isPalindrome("ab2a"));
		System.out.println(isPalindrome(",,,,"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("a"));
	}
}

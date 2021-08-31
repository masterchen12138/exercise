package days1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yec
 * @date 2021-01-21
 * 求一个字符串中不含重复字符的最长子串
 */
public class Day003 {
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> occ = new HashSet<>();
		int i = 0, rk = 0, n = s.length(), ans = 0;
		while (i < n) {
			if (ans > n - i - 1) {
				break;
			}
			if (i != 0) {
				occ.remove(s.charAt(i - 1));
			}
			while (rk < n && !occ.contains(s.charAt(rk))) {
				occ.add(s.charAt(rk));
				rk++;
			}
			ans = Math.max(ans, rk - i);
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("asdcvwefxcsc"));
	}
}

package days2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yec
 * @date 2021-08-25
 * 罗马数字转整数
 */
public class Day013 {
	public static int romanToInt(String s) {
		Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}};
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int a = symbolValues.get(s.charAt(i));
			if (i < s.length() - 1 && a < symbolValues.get(s.charAt(i + 1)))
				ans -= a;
			else
				ans += a;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("CXX"));
	}
}

package days3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Yec
 * @date 2021-08-25
 * 有效的括号
 */
public class Day020 {
	public static boolean isValid(String s) {
		int n = s.length();
		if (n % 2 == 1) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>() {{
			put(')', '(');
			put(']', '[');
			put('}', '{');
		}};
		Stack<Character> stack = new Stack<>();
		stack.push('a');
		for (int i = 0; i < s.length(); i++) {
			if (stack.peek() != map.get(s.charAt(i)))
				stack.push(s.charAt(i));
			else
				stack.pop();

		}
		stack.pop();
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("{[]}"));
	}
}

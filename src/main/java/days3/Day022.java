package days3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yec
 * @date 2021-08-25
 * 括号生成
 */
public class Day022 {
	static List<String> ans = new ArrayList<>();

	public static List<String> generateParenthesis(int n) {
		if (n <= 0)
			return ans;
		getParenthesis("", n, n);
		return ans;
	}

	public static void getParenthesis(String str, int left, int right) {
		if (left == 0 && right == 0) {
			ans.add(str);
			return;
		}
		if (left == right) {
			getParenthesis(str + "(", left - 1, right);
		} else if (left < right) {
			if (left > 0) {
				getParenthesis(str + "(", left - 1, right);
			}
			getParenthesis(str + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(1));
		System.out.println(generateParenthesis(2));
	}
}

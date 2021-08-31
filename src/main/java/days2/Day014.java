package days2;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Yec
 * @date 2021-08-25
 * 最长公共前缀
 */
public class Day014 {
	public static String longestCommonPrefix(String[] str) {
		if (str == null || str.length == 0) {
			return "";
		}
		int length = str[0].length();
		int count = str.length;
		for (int i = 0; i < length; i++) {
			char c = str[0].charAt(i);
			for (int j = 1; j < count; j++) {
				if (i == str[j].length() || str[j].charAt(i) != c) {
					return str[0].substring(0, i);
				}
			}
		}
		return str[0];
	}

	public static void main(String[] args) {
		String[] str = {"a"};
		System.out.println(longestCommonPrefix(str));
	}
}

package days3;

/**
 * @author Yec
 * @date 2021-08-26
 * 实现strStr()：查找一个字符串在另一个字符串中的出现位置
 */
public class Day028 {
	public static int strStr(String haystack, String needle) {
		//暴力匹配
		if ("".equals(needle))
			return 0;
		if ("".equals(haystack))
			return -1;
		int m = haystack.length();
		int n = needle.length();
		for (int i = 0; i <= m - n; i++) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}
}

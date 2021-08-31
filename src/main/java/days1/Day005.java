package days1;

/**
 * @author Yec
 * @date 2021-01-22
 * 查找最长回文子串
 */
public class Day005 {
	public static String longestPalindrome1(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}
		int maxLen = 1;
		int begin = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (j - i + 1 > maxLen && huiWen(s, i, j)) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

	/**
	 * 判断指定字符串的指定子串是否为回文串
	 */
	public static boolean huiWen(String str, int left, int right) {
		boolean isHuiWen = true;
		while (left < right) {
			if (str.charAt(left) != (str.charAt(right))) {
				isHuiWen = false;
			}
			left++;
			right--;
		}
		return isHuiWen;
	}

	/**
	 * 动态规划
	 */
	public static String longestPalindrome2(String s) {
		int len = s.length();
		// 如果只有一个字符或空字符，直接返回
		if (len < 2) {
			return s;
		}
		int maxLen = 1;
		int begin = 0;
		// 用dp[i][j]表示 s[i, j]是否是回文串
		boolean[][] dp = new boolean[len][len];
		char[] charArray = s.toCharArray();

		// 当i=j时，只有一个字符，必定属于回文串
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int j = 1; j < len; j++) {
			for (int i = 0; i < j; i++) {
				// 如果首尾字符不同，则不是回文串
				if (charArray[i] != charArray[j]) {
					dp[i][j] = false;
				} else {
					// 如果首尾字符相同，继续判断子串s[i+1,j-1]是否为回文串
					// 如果 j-1-(i+1)=j-i-2<1 ，即j-i<3时，子串s[i+1,j-1]只有一个字符，必定属于回文串
					if (j - i < 3) {
						dp[i][j] = true;
					} else {
						dp[i][j] = dp[i + 1][j - 1];
					}
				}
				// 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin + maxLen);
	}

	/**
	 * Manacher算法
	 */
	public String longestPalindrome(String s) {
		// 特判
		int len = s.length();
		if (len < 2) {
			return s;
		}

		// 得到预处理字符串
		String str = addBoundaries(s);
		// 新字符串的长度
		int sLen = 2 * len + 1;

		// 数组 p 记录了扫描过的回文子串的信息
		int[] p = new int[sLen];

		// 双指针，它们是一一对应的，须同时更新
		int maxRight = 0;
		int center = 0;

		// 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
		int maxLen = 1;
		// 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
		int start = 0;

		for (int i = 0; i < sLen; i++) {
			if (i < maxRight) {
				int mirror = 2 * center - i;
				// 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
				p[i] = Math.min(maxRight - i, p[mirror]);
			}

			// 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
			int left = i - (1 + p[i]);
			int right = i + (1 + p[i]);

			// left >= 0 && right < sLen 保证不越界
			// str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
			while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
				p[i]++;
				left--;
				right++;
			}
			// 根据maxRight的定义，它是遍历过的 i 的 i + p[i] 的最大者
			// 如果maxRight的值越大，进入上面i<maxRight的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
			if (i + p[i] > maxRight) {
				// maxRight 和 center 需要同时更新
				maxRight = i + p[i];
				center = i;
			}
			if (p[i] > maxLen) {
				// 记录最长回文子串的长度和相应它在原始字符串中的起点
				maxLen = p[i];
				start = (i - maxLen) / 2;
			}
		}
		return s.substring(start, start + maxLen);
	}

	private String addBoundaries(String s) {
		int len = s.length();
		if (len == 0) {
			return "";
		}
		if (s.indexOf('#') != -1) {
			throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			stringBuilder.append('#');
			stringBuilder.append(s.charAt(i));
		}
		stringBuilder.append('#');
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		String a = "vsadlfjvadgdav";
		System.out.println(longestPalindrome1(a));
		System.out.println(longestPalindrome2(a));
	}
}

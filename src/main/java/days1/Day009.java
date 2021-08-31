package days1;

/**
 * @author Yec
 * @date 2021-08-25
 * 回文数
 */
public class Day009 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12521));
		System.out.println(isPalindrome2(1246421));
	}

	public static boolean isPalindrome(int x) {
		//优化：排除负数，末位为0的非0数
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		String str1 = x + "";
		StringBuilder str = new StringBuilder(str1);
		StringBuilder reverse = str.reverse();
		return str1.equals(reverse.toString());
	}

	public static boolean isPalindrome2(int x) {
		//优化：排除负数，末位为0的非0数
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int num = 0;
		while (x > num) {
			num = num * 10 + x % 10;
			x /= 10;
		}
		return x == num || x == num / 10;
	}
}

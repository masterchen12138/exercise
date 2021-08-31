package days1;

/**
 * 整数反转
 *
 * @author Yec
 * @date 2021-01-26
 */
public class Day007 {
	public static int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			if ((ans * 10) / 10 != ans) {
				ans = 0;
				break;
			}
			ans = ans * 10 + x % 10;
			x = x / 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-46513));
	}
}

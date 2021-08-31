package days1;

/**
 * @author Yec
 * @date 2021-01-27
 */
public class Day008 {
	public static int myAtoi(String s) {
		boolean positive = true;
		long ans = 0L;
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == '-') {
			positive = false;
			s = s.substring(1);
		} else if (s.charAt(0) == '+') {
			s = s.substring(1);
		}
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				ans = ans * 10 + (s.charAt(i) - '0');
				if (positive && ans > Integer.MAX_VALUE) {
					ans = Integer.MAX_VALUE;
					break;
				}
				if (!positive && ans > Integer.MAX_VALUE + 1L) {
					ans = Integer.MAX_VALUE + 1L;
					break;
				}
			} else {
				break;
			}
		}
		return positive ? (int) ans : (int) -ans;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("+488494949489"));
	}
}

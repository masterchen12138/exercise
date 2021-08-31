package days1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yec
 * @date 2021-01-26
 * Z 字形变换
 */
public class Day006 {
	public static String convert(String s, int numRows) {
		// 边界
		if (numRows < 2) {
			return s;
		}
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		int i = 0, flag = -1;
		// 每当i为第0行或者最后一行，转向
		for (char c : s.toCharArray()) {
			rows.get(i).append(c);
			if (i == 0 || i == numRows - 1) {
				flag = -flag;
			}
			i += flag;
		}
		// 拼接结果
		StringBuilder res = new StringBuilder();
		for (StringBuilder row : rows) {
			res.append(row);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}
}

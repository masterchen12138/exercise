package days3;

import sun.print.SunMinMaxPage;

import java.util.Arrays;

/**
 * @author Yec
 * @date 2021-08-26
 * 删除数组重复项
 */
public class Day026 {
	public static int removeDuplicates(int[] nums) {
		int a = 1;
		int b = 1;
		while (a < nums.length) {
			if (nums[a] != nums[a - 1]) {
				nums[b] = nums[a];
				b++;
			}
			a++;
		}
		return b;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6};
		System.out.println(removeDuplicates(arr));
		System.out.println(Arrays.toString(arr));
	}
}

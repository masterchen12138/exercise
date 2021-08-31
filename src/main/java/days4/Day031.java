package days4;

import java.util.Arrays;

/**
 * @author Yec
 * @date 2021-08-26
 * 计算数组组成升序数字的下一个数字
 */
public class Day031 {
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		//从右往左，直到i右边的数组不是降序
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			//找出比num[i]大且最接近的数
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{2, 4, 3, 5, 6, 1};
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
}

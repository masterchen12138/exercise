package days4;

import java.util.Arrays;

/**
 * @author Yec
 * @date 2021-08-27
 * 查找目标元素在数组中首次和最后一次出现的位置
 */
public class Day034 {
	public static int[] searchRange(int[] nums, int target) {
		int left = binarySearch(nums, target, true);
		int right = binarySearch(nums, target, false) - 1;
		if (left <= right && right < nums.length && nums[left] == target && nums[right] == target)
			return new int[]{left, right};
		return new int[]{-1, -1};
	}

	public static int binarySearch(int[] nums, int target, boolean next) {
		int left = 0, right = nums.length - 1, ans = nums.length;
		while (left <= right) {
			int mid = (left + right) / 2;
			//若next为true，条件变为nums[mid] == target，即寻找目标值位置
			//若next为false，条件nums[mid] > target，即寻找比目标值大的值的位置
			if (nums[mid] > target || (next && nums[mid] == target)) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[]{1, 5, 7, 7, 8, 8, 10}, 7)));
	}
}

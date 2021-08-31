package days4;

/**
 * @author Yec
 * @date 2021-08-27
 * 搜索旋转排序数组
 */
public class Day033 {
	public static int search(int[] nums, int target) {
		int n = nums.length;
		if (n == 0) return -1;
		if (n == 1) return nums[0] == target ? 0 : -1;
		int l = 0, r = n - 1;
		while (l <= r) {
			//二分数组，必定有一部分有序
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[l] <= nums[mid]) {
				//(0,mid)为有序数组
				if (nums[l] <= target && target < nums[mid])
					r = mid - 1;
				else
					l = mid + 1;
			} else {
				if (nums[mid] < target && target <= nums[n - 1])
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
	}
}

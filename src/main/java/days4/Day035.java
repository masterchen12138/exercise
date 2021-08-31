package days4;

/**
 * @author Yec
 * @date 2021-08-27
 * 搜索插入位置
 */
public class Day035 {
	public static int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			//防止left+right溢出
			int mid = ((right - left) >> 1) + left;
			if (nums[mid] >= target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
	}
}

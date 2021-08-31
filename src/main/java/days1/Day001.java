package days1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yec
 * @create 2021-01-18
 * 求数组中是否存在两个数，其和等于目标数，若存在则返回下标
 */
public class Day001 {
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashtable = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			//遍历数组时，查找是否存在(target-当前数字)
			if (hashtable.containsKey(target - nums[i])) {
				return new int[]{hashtable.get(target - nums[i]), i};
			}
			hashtable.put(nums[i], i);
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int[] ints = twoSum2(nums, 6);
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}
}

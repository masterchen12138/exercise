package days3;

import java.util.Arrays;

/**
 * @author Yec
 * @date 2021-08-26
 * 移除数组元素
 */
public class Day027 {
	public static int removeElement(int[] nums, int val) {
		int a = 0, b = 0;
		while (a < nums.length) {
			if (nums[a] != val) {
				nums[b] = nums[a];
				b++;
			}
			a++;
		}
		return b;

//		int index = 0;
//		for(int num : nums){
//			if(num != val){
//				nums[index++] = num;
//			}
//		}
//		return index;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 3, 4, 5, 6};
		System.out.println(removeElement(arr, 3));
		System.out.println(Arrays.toString(arr));
	}
}

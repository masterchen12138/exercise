package days2;

/**
 * @author Yec
 * @date 2021-08-25
 * 盛最多水的容器
 */
public class Day011 {
	public static int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
			if (height[start] < height[end])
				start++;
			else
				end--;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {4,3,2,1,4};
		System.out.println(maxArea(arr));
	}
}

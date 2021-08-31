package days1;

/**
 * @author Yec
 * @date 2021-01-21
 * 寻找两个正序数组的中位数
 */
public class Day004 {
	/**
	 * 方法2：根据中位数的定义
	 * 当m+n是奇数时，中位数是两个有序数组中的第(m+n)/2个元素
	 * 当m+n是偶数时，中位数是两个有序数组中的第(m+n)/2个元素和第(m+n)/2+1个元素的平均值
	 * 因此，这道题可以转化成寻找两个有序数组中的第k小的数，其中k为(m+n)/2或(m+n)/2+1
	 * 假设两个有序数组分别是A和B。要找到第k个元素，我们可以比较A[k/2−1]和B[k/2−1]
	 * 由于A[k/2−1]和B[k/2−1]的前面分别有A[0..k/2−2] 和B[0..k/2−2]，即k/2−1个元素
	 * 对于A[k/2−1]和B[k/2−1]中的较小值，最多只会有(k/2−1)+(k/2−1)≤k−2个元素比它小，那么它就不能是第k小的数了
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length, length2 = nums2.length;
		int totalLength = length1 + length2;
		if (totalLength % 2 == 1) {
			int midIndex = totalLength / 2;
			return getKthElement(nums1, nums2, midIndex + 1);
		} else {
			int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
			return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
		}
	}

	public static int getKthElement(int[] nums1, int[] nums2, int k) {
		int length1 = nums1.length, length2 = nums2.length;
		int index1 = 0, index2 = 0;

		while (true) {
			// 边界情况
			if (index1 == length1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == length2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			// 正常情况
			int half = k / 2;
			int newIndex1 = Math.min(index1 + half, length1) - 1;
			int newIndex2 = Math.min(index2 + half, length2) - 1;
			int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
			if (pivot1 <= pivot2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays1(nums2, nums1);
		}

		int m = nums1.length;
		int n = nums2.length;
		int left = 0, right = m;
		// median1：前一部分的最大值
		// median2：后一部分的最小值
		int median1 = 0, median2 = 0;

		while (left <= right) {
			// 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
			// 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
			int i = (left + right) / 2;
			int j = (m + n + 1) / 2 - i;

			// nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
			int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
			int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
			int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
			int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

			if (nums_im1 <= nums_j) {
				median1 = Math.max(nums_im1, nums_jm1);
				median2 = Math.min(nums_i, nums_j);
				left = i + 1;
			} else {
				right = i - 1;
			}
		}
		return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 6, 8}));
		System.out.println(findMedianSortedArrays1(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 6, 8}));
	}
}

package divide_and_conquer;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * <p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {

	public static class Solution1 {

		public int majorityElement(int[] nums) {
			return majorityElement(nums, 0, nums.length - 1);
		}

		public int majorityElement(int[] nums, int left, int right) {
			if (left == right || right - left == 1) {
				return nums[left];
			}
			int mid = (left + right) / 2;
			int leftMajor = majorityElement(nums, left, mid);
			int rightMajor = majorityElement(nums, mid + 1, right);
			if (leftMajor == rightMajor) {
				return leftMajor;
			}
			long leftCount = Arrays.stream(nums, left, mid + 1)
					.filter(n -> n == leftMajor).count();
			long rightCount = Arrays.stream(nums, mid + 1, right + 1)
					.filter(n -> n == rightMajor).count();
			if (leftCount > rightCount) {
				return leftMajor;
			} else {
				return rightMajor;
			}

		}
	}

}

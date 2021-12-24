package divide_and_conquer;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 53. 最大子数组和
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {


	// 分治
	public static class Solution1 {

		public int maxSubArray(int[] array) {
			return maxSubArray(array, 0, array.length - 1);
		}

		private int maxSubArray(int[] array, int left, int right) {
			if (left == right) {
				return array[left];
			}
			if (right - left == 1) {
				return max(array[right], array[left], array[right] + array[left]);
			}

			int mid = (left + right) / 2;

			int leftMaxSum = maxSubArray(array, left, mid - 1);
			int rightMaxSum = maxSubArray(array, mid + 1, right);
			int midMaxSum = midMaxSum(array, left, right, mid);

			return max(leftMaxSum, rightMaxSum, midMaxSum);
		}

		private int midMaxSum(int[] array, int left, int right, int mid) {
			int leftSum = 0;
			int leftMax = 0;
			for (int i = mid - 1; i >= left; i--) {
				leftSum += array[i];
				if (leftSum > leftMax) {
					leftMax = leftSum;
				}
			}
			int rightSum = 0;
			int rightMax = 0;
			for (int i = mid + 1; i <= right; i++) {
				rightSum += array[i];
				if (rightSum > rightMax) {
					rightMax = rightSum;
				}
			}
			return leftMax + array[mid] + rightMax;
		}
	}

	//暴力
	public static class Solution2 {

		public int maxSubArray(int[] array) {
			int maxValue = Integer.MIN_VALUE;
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j <= i; j++) {
					int sum = Arrays.stream(Arrays.copyOfRange(array, j, i + 1)).sum();
					if (sum > maxValue) {
						maxValue = sum;
					}
				}
			}
			return maxValue;
		}
	}

	// dp
	public static class Solution3 {

		public int maxSubArray(int[] nums) {
			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			int max = dp[0];
			for (int i = 1; i < nums.length; i++) {
				int m = Math.max(nums[i], dp[i - 1] + nums[i]);
				dp[i] = m;
				if (m > max) {
					max = m;
				}
			}
			return max;
		}
	}


	// 最大值
	public static int max(int... nums) {
		OptionalInt max = Arrays.stream(nums).max();
		return max.isPresent() ? max.getAsInt() : 0;
	}

}

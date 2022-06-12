package leetcode.editor.cn.sort;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 * 基数排序
 * <p>
 * 取得数组中的最大数，并取得位数；
 * <p>
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * <p>
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 */
public class RadixSort {

	public static class Solution {

		public int[] sort(int[] nums) {

			//取得数组中的最大数，并取得位数
			int digit = getBiggestDigit(nums);

			// i=0表示个位； i=1表示十位
			for (int i = 1; i <= digit; i++) {
				// 每一个位置都过一下桶数组
				bucket(nums, i);
			}

			return nums;
		}

		//// i=1表示个位； i=2表示十位 ......
		private void bucket(int[] nums, int i) {
			List<Integer>[] buckets = new List[10];
			// 把数组，放置到桶中
			for (int n : nums) {
				// 获取对应位数的数值
				int pos = getPosition(n, i);
				List<Integer> list = buckets[pos];
				if (list == null) {
					list = new ArrayList<>();
					buckets[pos] = list;
				}
				list.add(n);
			}
			// 再把桶中到数据，恢复到原数组中
			int index = 0;
			for (List<Integer> bucket : buckets) {
				if (CollectionUtils.isNotEmpty(bucket)) {
					for (Integer v : bucket) {
						nums[index] = v;
						index++;
					}
				}
			}
		}

		// 获取对应位数的数值
		private int getPosition(int n, int digit) {
			String s = String.valueOf(n);
			// 33   2
			if (s.length() < digit) {
				return 0;
			}
			return Integer.parseInt(s.substring(s.length() - digit, s.length() - digit + 1));
		}

		// 取得数组中的最大数，并取得位数
		private int getBiggestDigit(int[] nums) {
			int maxDigit = 0;
			for (int num : nums) {
				int d = String.valueOf(num).length();
				maxDigit = Math.max(maxDigit, d);
			}
			return maxDigit;
		}
	}

}

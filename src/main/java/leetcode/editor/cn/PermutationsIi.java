package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * [47] 全排列 II
 */
public class PermutationsIi {


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private List<List<Integer>> result = new ArrayList<>();
		private final Set<String> cache = new HashSet<>();

		// 输入：nums = [1,1,2] 输出： [[1,1,2], [1,2,1], [2,1,1]]
		public List<List<Integer>> permuteUnique(int[] nums) {
			if (nums == null || nums.length == 0) {
				return result;
			}
			permuteUnique(nums, nums.length);
			return result;
		}

		// 前k个元素的全排列
		private void permuteUnique(int[] nums, int k) {
			Integer currentItem = nums[k - 1];
			// 递归出口
			if (k == 1) {
				List<Integer> list = new LinkedList<>();
				list.add(currentItem);
				result.add(list);
				return;
			}

			// 计算出 前k-1个元素的全排列
			permuteUnique(nums, k - 1);

			// 把当前元素插入到 之前元素的排列中
			List<List<Integer>> newResult = new ArrayList<>();
			result.forEach(r -> {
				// 复制一份
				int size = r.size();
				for (int i = 0; i <= size; i++) {
					// 各个间隙， 插入新元素
					LinkedList<Integer> l = new LinkedList<>(r);
					l.add(i, currentItem);
					// 剪支、判断是否有重复
					String s = Arrays.toString(l.toArray());
					if (!hasSame(s)) {
						newResult.add(l);
						cache.add(s);
					}
				}
			});
			result = newResult;
			cache.clear();
		}

		private boolean hasSame(String l) {
			return cache.contains(l);
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
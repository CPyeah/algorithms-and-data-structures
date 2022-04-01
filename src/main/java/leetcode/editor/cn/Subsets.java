package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [78] 子集
 * <p>
 * 遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
 */
public class Subsets {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> subSet = new ArrayList<>();
			dfs(nums, 0, result, subSet);
			return result;
		}

		// 遍历第 i 层
		private void dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> subSet) {
			// 如果是根节点， 存储子集 and 返回
			if (i >= nums.length) {
				result.add(new ArrayList<>(subSet));
				return;
			}

			// 取当前值
			subSet.add(nums[i]);
			dfs(nums, i + 1, result, subSet);

			// 不取当前值
			subSet.remove(subSet.size() - 1);
			dfs(nums, i + 1, result, subSet);

		}

	}
//leetcode submit region end(Prohibit modification and deletion)

	class Solution2 {

		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			for (int num : nums) {
				int size = result.size();
				for (int j = 0; j < size; j++) {
					List<Integer> newList = new ArrayList<>(result.get(j));
					newList.add(num);
					result.add(newList);
				}
			}
			return result;
		}
	}
}
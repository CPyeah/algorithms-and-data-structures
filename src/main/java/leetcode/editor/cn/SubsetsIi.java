package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [90] 子集 II
 */
public class SubsetsIi {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private List<List<Integer>> result = new ArrayList<>();
		private Set<String> setResult = new HashSet<>();

		// 输入：nums = [1,2,2]
		// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			Arrays.sort(nums);
			subSets(nums, nums.length);
			return result;
		}

		// 前K个元素的子集
		// 等于  前 K-1 个元素的子集  加 当前元素
		private void subSets(int[] nums, int k) {
			if (k == 0) {
				result.add(new ArrayList<>());
				setResult.add("");
				return;
			}
			// 获得 k -1 个元素的子集
			subSets(nums, k - 1);

			// 与当前元素做组合  形成新的子集
			int currentNum = nums[k-1];
			int beforeSize = result.size();
			for (int i = 0; i < beforeSize; i++) {
				List<Integer> newSet = new ArrayList<>(result.get(i));
				newSet.add(currentNum);
				String setString = Arrays.toString(newSet.toArray(new Integer[0]));
				// 剪支， 如果已经存在子集，则不添加
				if (!hasSameSet(setString)) {
					result.add(newSet);
					setResult.add(setString);
				}
			}

		}

		// 在result中， 是否有重复的
		private boolean hasSameSet(String setString) {
			return setResult.contains(setString);
		}




	}
//leetcode submit region end(Prohibit modification and deletion)

}
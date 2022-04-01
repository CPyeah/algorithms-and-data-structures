package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [46] 全排列
 */
public class Permutations {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private final List<List<Integer>> result = new ArrayList<>();

		//输入：nums = [1,2,3]
		//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		public List<List<Integer>> permute(int[] nums) {
			permute(nums, nums.length);
			return result;
		}

		// 前 K 个元素的全排列
		private void permute(int[] nums, int k) {
			int currentNum = nums[k - 1];
			if (k == 1) {
				List<Integer> list = new LinkedList<>();
				list.add(currentNum);
				result.add(list);
				return;
			}
			// k - 1 个元素 全排列
			permute(nums, k - 1);

			// 控制边界
			int size = result.size();
			// 把当前元素分别插入到间隙中
			for (int i = 0; i < size; i++) {
				// 把当前不完整的结果集，移除出来，注意index和边界
				LinkedList<Integer> list = (LinkedList<Integer>) result.remove(i);
				size--;
				i--;
				// 循环在不同的间隙 插入当前元素， 加入结果集
				for (int j = 0; j <= list.size(); j++) {
					LinkedList<Integer> newList = new LinkedList<>(list);
					newList.add(j, currentNum);
					result.add(newList);
				}
			}
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
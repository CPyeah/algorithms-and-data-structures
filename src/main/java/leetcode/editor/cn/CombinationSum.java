package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [39] 组合总和
 */
public class CombinationSum {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private final List<List<Integer>> result = new ArrayList<>();

		//输入：candidates = [2,3,6,7], target = 7
		//输出：[[2,2,3],[7]]
		//              [],7
		//   [2],5    [3],4    [6],1     [7],0
		//  [2,2],3   [2,3],2 ....
		//  [2,2,2],1   [2,2,3],0
		//  [2,2,2,2],-1   [2,2,2,3],-2
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			Arrays.sort(candidates);
			backTrack(candidates, target, new ArrayList<>(), 0);
			return result;
		}


		public void backTrack(int[] candidates, int target, List<Integer> answer, int startIndex) {
			// 如果剩余的 值 为0， 复制后 添加到结果集
			if (target == 0) {
				result.add(new ArrayList<>(answer));
				return;
			}

			// 在当前结果中，尝试添加每一个候选项（除了前面算过的）
			// 如果 候选项 小于等于 剩余目标值， 可以进行下次迭代
			for (int i = startIndex; i < candidates.length; i++) {
				int candidate = candidates[i];
				if (target >= candidate) {
					List<Integer> newAnswer = new ArrayList<>(answer);
					newAnswer.add(candidate);
					backTrack(candidates, target - candidate, newAnswer, i);
				}
			}


		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
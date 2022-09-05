package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [416] 分割等和子集
 */
public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		Solution solution = new PartitionEqualSubsetSum().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public boolean canPartition(int[] nums) {
			// get target
			int target = 0;
			for (int n : nums) {
				target += n;
			}
			if (target % 2 != 0) {
				return false;
			}
			target = target / 2;

			// dp  select or not select
			List<Integer> dp = new ArrayList<>();
			dp.add(0);
			for(int n : nums) {
				int size = dp.size();
				for (int i = 0; i < size; i++) {
					int newNumber = n + dp.get(i);
					if (newNumber == target) {
						return true;
					}
					if (newNumber < target) {
						dp.add(newNumber);
					}
				}
			}

			return false;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
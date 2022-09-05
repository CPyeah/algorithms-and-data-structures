package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

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
			Set<Integer> dp = new HashSet<>();
			dp.add(0);
			Set<Integer> temp = new HashSet<>();
			for(int n : nums) {
				for (Integer i : dp) {
					int newNumber = n + i;
					if (newNumber == target) {
						return true;
					}
					if (newNumber < target) {
						temp.add(newNumber);
					}
				}
				dp.addAll(temp);
				temp.clear();
			}

			return false;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
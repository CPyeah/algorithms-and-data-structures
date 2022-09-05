package leetcode.editor.cn;

/**
 * [461] 汉明距离
 */
public class HammingDistance {

	public static void main(String[] args) {
		Solution solution = new HammingDistance().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int hammingDistance(int x, int y) {
			int diff = x^y;
			// how many 1 in diff num
			int ans = 0;
			while (diff > 0) {
				if (diff % 2 == 1) {
					ans++;
				}
				diff /= 2;
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
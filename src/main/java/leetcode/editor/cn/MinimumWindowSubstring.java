package leetcode.editor.cn;

import java.util.Arrays;

/**
 * [76] 最小覆盖子串
 */
public class MinimumWindowSubstring {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public String minWindow(String s, String t) {
			// 记录最小子串的起始位置 and 子串长度
			int minStartIndex = -1, minLength = Integer.MAX_VALUE;
			// 滑动窗口的 左右指针
			int left = 0, right = 0;

			// 目标字符串 数组形态的Map形式，存储 t 的结构，方便比较
			int[] targetStringMap = getTargetStringMap(t);

			// 注意循环停止时机
			while (right <= s.length()) {
				if (!isContains(s, left, right, targetStringMap, t.length())) {
					// 如果 子串不包含， 右指针往右移动
					right++;
				} else {
					// 如果 子串包含
					// 比较是否最小，记录
					if (right - left < minLength) {
						minStartIndex = left;
						minLength = right - left;
					}
					// 左指针左移
					left++;
				}
			}
			return minStartIndex != -1 ? s.substring(minStartIndex, minStartIndex + minLength) : "";
		}

		private int[] getTargetStringMap(String t) {
			int[] map = new int[256];
			for (char c : t.toCharArray()) {
				map[c]++;
			}
			return map;
		}

		/**
		 * 是否 sub string 包含 t
		 *
		 * @param s                A DOB ECODEBANC
		 * @param left             1
		 * @param right            4
		 * @param targetStringMap  ABC
		 * @param targetStringSize 3
		 * @return true/false
		 */
		private boolean isContains(String s, int left, int right, int[] targetStringMap,
				int targetStringSize) {
			if (left == right) {
				return false;
			}
			int[] targetCopy = Arrays.copyOf(targetStringMap, targetStringMap.length);
			char[] source = s.toCharArray();
			for (int i = left; i < right; i++) {
				char c = source[i];
				int count = targetCopy[c];
				if (count > 0) {
					targetCopy[c]--;
					targetStringSize--;
				}
			}
			return targetStringSize == 0;
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * [76] 最小覆盖子串
 */
public class MinimumWindowSubstring {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public String minWindow(String s, String t) {
			String result = "";
			int minSize = t.length();
			for (int i = minSize; i <= s.length(); i++) {
				// 以i为滑动窗口的距离
				for (int j = 0; j <= s.length() - i; j++) {
					String subString = s.substring(j, j + i);
					if (isContains(subString, t)) {
						return subString;
					}
				}
			}
			return result;
		}

		// subString 是否 包含 t里面的全部字符
		private boolean isContains(String subString, String t) {
			List<Character> collect = subString.chars().mapToObj(c -> (char) c)
					.collect(Collectors.toList());
			for (char c : t.toCharArray()) {
				if (collect.contains(c)) {
					collect.remove(Character.valueOf(c));
				} else {
					return false;
				}
			}
			return true;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
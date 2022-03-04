package leetcode.editor.cn;

public class ImplementStrstr {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int strStr(String haystack, String needle) {
			for (int i = 0; i <= haystack.length() - needle.length(); i++) {
				String substring = haystack.substring(i, i + needle.length());
				if (substring.equals(needle)) {
					return i;
				}
			}
			return -1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
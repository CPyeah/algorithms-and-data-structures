package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [3] 无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int lengthOfLongestSubstring(String s) {
			if (s == null || s.length() == 0) {
				return 0;
			}
			int maxLength = 1;
			CharsHolder holder = new CharsHolder();
			int left = 0, right = 0;
			while (right <= s.length()) {
				// 如果无重复
				if (holder.noRepetition()) {
					maxLength = Math.max(maxLength, right - left);
					if (right < s.length()) {
						holder.add(s.charAt(right));
					}
					right++;
				}
				// 如果有重复
				while (!holder.noRepetition()) {
					holder.remove(s.charAt(left));
					left++;
				}
			}
			return maxLength;
		}

		class CharsHolder {

			private final Map<Character, Integer> holder = new HashMap<>();

			boolean noRepetition() {
				return holder.values().stream()
						.noneMatch(v -> v > 1);
			}

			void add(Character c) {
				Integer count = holder.getOrDefault(c, 0);
				holder.put(c, ++count);
			}

			void remove(Character c) {
				Integer count = holder.get(c);
				holder.put(c, --count);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
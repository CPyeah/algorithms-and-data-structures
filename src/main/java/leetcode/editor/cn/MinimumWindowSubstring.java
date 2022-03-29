package leetcode.editor.cn;

import java.util.HashMap;

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
			DiffCharsHolder holder = new DiffCharsHolder(t);
			// 注意循环停止时机
			// "ADOBECODEBANC", "ABC"
			while (right < s.length()) {
				if (!holder.isEmpty()) {
					// 如果 子串不包含， 右指针往右移动
					right++;
					char c = s.charAt(right - 1);
					holder.remove(c);
				}
				while (holder.isEmpty()) {
					// 如果 子串包含
					// 比较是否最小，记录
					if (right - left < minLength) {
						minStartIndex = left;
						minLength = right - left;
					}
					// 左指针左移
					left++;
					char c = s.charAt(left - 1);
					holder.add(c);
				}
			}
			return minStartIndex != -1 ? s.substring(minStartIndex, minStartIndex + minLength) : "";
		}


		class DiffCharsHolder {

			// 存储待覆盖字符个数Map
			private final HashMap<Character, Integer> holder = new HashMap<>();

			// 构造方法， 初始化 待覆盖字符个数
			DiffCharsHolder(String targetString) {
				for (char character : targetString.toCharArray()) {
					Integer count = holder.getOrDefault(character, 0);
					holder.put(character, ++count);
				}
			}

			// 尝试移除一个 覆盖字符
			void remove(Character character) {
				Integer count = holder.get(character);
				if (count != null) {
					holder.put(character, --count);
				}
			}

			// 是否为空，即是否字符已经全部覆盖
			boolean isEmpty() {
				return holder.values().stream().noneMatch(c -> c > 0);
			}

			// 如果是关键字符，添加它
			void add(Character character) {
				Integer count = holder.get(character);
				if (count != null) {
					holder.put(character, ++count);
				}
			}

		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
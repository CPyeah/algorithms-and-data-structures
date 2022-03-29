package leetcode.editor.cn;

import java.util.HashMap;

/**
 * [567] 字符串的排列
 */
public class PermutationInString {


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// s1 = "ab" s2 = "eidbaooo"
		public boolean checkInclusion(String s1, String s2) {
			if (s1.length() > s2.length()) {
				return false;
			}

			int left = 0, right = s1.length();

			DiffCharsHolder holder = new DiffCharsHolder(s1);
			for (int i = 0; i < s1.length(); i++) {
				holder.remove(s2.charAt(i));
			}

			while (true) {
				if (holder.isEmpty()) {
					return true;
				}
				if (right >= s2.length()) {
					break;
				}
				holder.remove(s2.charAt(right));
				holder.add(s2.charAt(left));
				left++;
				right++;
			}

			return false;
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
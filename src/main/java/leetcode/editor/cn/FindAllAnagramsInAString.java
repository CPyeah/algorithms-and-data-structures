package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [438] 找到字符串中所有字母异位词
 */
public class FindAllAnagramsInAString {


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// s = "cbaebabacd", p = "abc"
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> result = new ArrayList<>();
			if (p.length() > s.length()) {
				return result;
			}

			int left = 0, right = p.length();

			DiffCharsHolder holder
					= new DiffCharsHolder(p);
			for (int i = 0; i < p.length(); i++) {
				holder.remove(s.charAt(i));
			}

			while (true) {
				if (holder.isEmpty()) {
					result.add(left);
				}
				if (right >= s.length()) {
					break;
				}
				holder.remove(s.charAt(right));
				holder.add(s.charAt(left));
				left++;
				right++;
			}

			return result;
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
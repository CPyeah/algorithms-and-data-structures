package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [20] 有效的括号
 */
public class ValidParentheses {

	public static void main(String[] args) {
		Solution solution = new ValidParentheses().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		Map<Character, Character> map = new HashMap<>(6);

		{
			map.put('(', ')');
			map.put('[', ']');
			map.put('{', '}');
		}

		public boolean isValid(String s) {
			List<Character> stack = new ArrayList<>(s.length() / 2);
			for (Character c : s.toCharArray()) {
				if (isLeft(c)) {
					stack.add(c);
				} else {
					if (stack.isEmpty()) {
						return false;
					}
					Character expect = map.get(stack.remove(stack.size() - 1));
					if (expect == null || !expect.equals(c)) {
						return false;
					}
				}
			}

			return stack.isEmpty();
		}

		private boolean isLeft(Character c) {
			return map.containsKey(c);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
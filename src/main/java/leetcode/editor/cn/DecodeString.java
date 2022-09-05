package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [394] 字符串解码
 */
public class DecodeString {

	public static void main(String[] args) {
		Solution solution = new DecodeString().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public String decodeString(String s) {
			char[] chars = s.toCharArray();
			List<Character> stack = new ArrayList<>();
			for (int i = 0; i < chars.length; i++) {
				char currentChar = chars[i];
				if (']' == currentChar) {
					// find target chars in []
					List<Character> targetChars = new ArrayList<>();
					for (int j = stack.size()-1; j > -1; j--) {
						if (stack.get(j) == '[') {
							stack.remove(j);
							break;
						}
						targetChars.add(stack.get(j));
						stack.remove(j);
					}
					Collections.reverse(targetChars);
					// find number
					List<Character> numberChars = new ArrayList<>();
					for (int j = stack.size()-1; j > -1; j--) {
						if (Character.isDigit(stack.get(j))) {
							numberChars.add(stack.get(j));
							stack.remove(j);
						} else {
							break;
						}
					}
					Collections.reverse(numberChars);
					StringBuilder sb = new StringBuilder();
					for (Character c : numberChars) {
						sb.append(c);
					}
					Integer number = Integer.parseInt(sb.toString());

					// copy and add to stack
					for (int j = 0; j < number; j++) {
						stack.addAll(targetChars);
					}

				} else {
					//just add to stack
					stack.add(currentChar);
				}
			}
			// stack to string
			StringBuilder sb = new StringBuilder();
			for (Character c : stack) {
				sb.append(c);
			}
			return sb.toString();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
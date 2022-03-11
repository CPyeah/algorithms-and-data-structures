package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [150] 逆波兰表达式求值
 */
public class EvaluateReversePolishNotation {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int evalRPN(String[] tokens) {
			// 操作数栈
			ArrayList<Integer> stack = new ArrayList<>();

			Arrays.stream(tokens).forEach(token -> {
				if (isNumber(token)) {
					stack.add(Integer.parseInt(token));
				} else {
					Integer result = null;
					Integer second = stack.remove(stack.size() - 1);
					Integer first = stack.remove(stack.size() - 1);
					if ("+".equals(token)) {
						result = first + second;
					} else if ("-".equals(token)) {
						result = first - second;
					} else if ("*".equals(token)) {
						result = first * second;
					} else if ("/".equals(token)) {
						result = first / second;
					}

					stack.add(result);
				}
			});
			return stack.get(0);
		}

		private boolean isNumber(String token) {
			return !("+".equals(token)
					|| "-".equals(token)
					|| "*".equals(token)
					|| "/".equals(token));
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
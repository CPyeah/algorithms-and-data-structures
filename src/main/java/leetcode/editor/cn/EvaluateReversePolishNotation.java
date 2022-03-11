package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * [150] 逆波兰表达式求值
 */
public class EvaluateReversePolishNotation {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();

		{
			map.put("+", Integer::sum);
			map.put("-", (a, b) -> a - b);
			map.put("*", (a, b) -> a * b);
			map.put("/", (a, b) -> a / b);
		}

		public int evalRPN(String[] tokens) {

			// 操作数栈
			ArrayList<Integer> stack = new ArrayList<>(tokens.length / 2);

			Arrays.stream(tokens).forEach(token -> {
				if (isNumber(token)) {
					stack.add(Integer.parseInt(token));
				} else {
					Integer second = stack.remove(stack.size() - 1);
					Integer first = stack.remove(stack.size() - 1);
					Integer result = map.get(token).apply(first, second);
					stack.add(result);
				}
			});
			return stack.get(0);
		}

		private boolean isNumber(String token) {
			return !map.containsKey(token);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
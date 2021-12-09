package stack;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import model.MyStack;

public class ParenthesisMatching {


	static Map<String, String> parenthesisMap = ImmutableMap.of("(", ")", "[", "]", "{", "}");


	public boolean solution(String s) {
		MyStack<String> stack = new MyStack<>();
		String[] array = s.split("");
		for (String i : array) {
			if (isLeft(i)) {
				stack.push(i);
			} else if (isRight(i)) {
				String left = stack.pop();
				if (isNotMatch(i, left)) {
					return false;
				}
			}
		}
		return stack.pop() == null;
	}

	private boolean isLeft(String i) {
		return parenthesisMap.containsKey(i);
	}

	private boolean isRight(String i) {
		return parenthesisMap.containsValue(i);
	}

	private boolean isNotMatch(String expectRight, String left) {
		String right = parenthesisMap.get(left);
		return right == null || !right.equals(expectRight);
	}


}

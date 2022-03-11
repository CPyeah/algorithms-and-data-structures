package leetcode.editor.cn;

import leetcode.editor.cn.ValidParentheses.Solution;
import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

	@Test
	public void test() {
		Solution solution = new ValidParentheses().new Solution();
		Assert.assertTrue(solution.isValid("()[]{}"));
		Assert.assertFalse(solution.isValid("([)]"));
	}

}
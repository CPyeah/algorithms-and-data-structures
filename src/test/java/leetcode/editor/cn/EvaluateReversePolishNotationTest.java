package leetcode.editor.cn;

import leetcode.editor.cn.EvaluateReversePolishNotation.Solution;
import org.junit.Assert;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {

	@Test
	public void test() {
		Solution solution = new EvaluateReversePolishNotation().new Solution();
		int result = solution.evalRPN(new String[]{"2", "1", "+", "3", "*"});
		Assert.assertEquals(9, result);
	}

}
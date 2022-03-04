package leetcode.editor.cn;

import leetcode.editor.cn.ImplementStrstr.Solution;
import org.junit.Assert;
import org.junit.Test;

public class ImplementStrstrTest {

	@Test
	public void test() {
		Solution solution = new ImplementStrstr().new Solution();
		Assert.assertEquals(2, solution.strStr("hello", "ll"));
	}

}
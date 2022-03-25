package leetcode.editor.cn;

import leetcode.editor.cn.MinimumWindowSubstring.Solution;
import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubstringTest {

	@Test
	public void test() {
		Solution solution = new MinimumWindowSubstring().new Solution();
		String r = solution.minWindow("ADOBECODEBANC", "ABC");
		Assert.assertEquals("BANC", r);
	}

}
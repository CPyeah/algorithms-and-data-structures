package leetcode.editor.cn;

import leetcode.editor.cn.PermutationInString.Solution;
import org.junit.Assert;
import org.junit.Test;

public class PermutationInStringTest {

	@Test
	public void test() {
		Solution solution = new PermutationInString().new Solution();
		boolean b = solution.checkInclusion("ab", "eidbaooo");
		Assert.assertTrue(b);
		b = solution.checkInclusion("ab", "eidboaoo");
		Assert.assertFalse(b);
		b = solution.checkInclusion("a", "ab");
		Assert.assertTrue(b);
	}

}
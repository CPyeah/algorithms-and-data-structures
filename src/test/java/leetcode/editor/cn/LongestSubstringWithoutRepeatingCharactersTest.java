package leetcode.editor.cn;

import leetcode.editor.cn.LongestSubstringWithoutRepeatingCharacters.Solution;
import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
	@Test
	public void test() {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		Assert.assertEquals(2, solution.lengthOfLongestSubstring("ab"));
		Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
		Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
		Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
	}
}
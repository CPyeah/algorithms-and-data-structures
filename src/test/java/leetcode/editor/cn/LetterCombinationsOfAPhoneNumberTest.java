package leetcode.editor.cn;

import leetcode.editor.cn.LetterCombinationsOfAPhoneNumber.Solution;
import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationsOfAPhoneNumberTest {

	@Test
	public void test() {
		Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
		Assert.assertEquals(9, solution.letterCombinations("23").size());
	}

}
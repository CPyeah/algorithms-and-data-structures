package leetcode.editor.cn;

import leetcode.editor.cn.FindMinimumInRotatedSortedArrayIi.Solution;
import org.junit.Assert;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayIiTest {

	@Test
	public void test() {
		Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
		Assert.assertEquals(1, solution.findMin(new int[]{3, 3, 1, 3, 3}));
	}

}
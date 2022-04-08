package leetcode.editor.cn;

import leetcode.editor.cn.FindMinimumInRotatedSortedArray.Solution;
import org.junit.Assert;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {

	@Test
	public void test() {
		Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
		Assert.assertEquals(1, solution.findMin(new int[]{3,4,5,1,2}));
	}

}
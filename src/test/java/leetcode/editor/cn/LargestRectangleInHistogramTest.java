package leetcode.editor.cn;

import leetcode.editor.cn.LargestRectangleInHistogram.Solution;
import leetcode.editor.cn.LargestRectangleInHistogram.Solution2;
import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleInHistogramTest {

	@Test
	public void test() {
		Solution solution = new LargestRectangleInHistogram().new Solution();
		int result = solution.largestRectangleArea(new int[]{2,1,2});
		Assert.assertEquals(3, result);
		result = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
		Assert.assertEquals(10, result);
		result = solution.largestRectangleArea(new int[]{2, 4});
		Assert.assertEquals(4, result);

	}

	@Test
	public void test2() {
		Solution2 solution = new LargestRectangleInHistogram().new Solution2();
		int result = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
		Assert.assertEquals(10, result);
		result = solution.largestRectangleArea(new int[]{2, 4});
		Assert.assertEquals(4, result);

	}

}
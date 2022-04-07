package leetcode.editor.cn;

import leetcode.editor.cn.SearchA2dMatrix.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SearchA2dMatrixTest {

	@Test
	public void test() {
		Solution solution = new SearchA2dMatrix().new Solution();
		boolean b = solution
				.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);
		Assert.assertTrue(b);
	}

}
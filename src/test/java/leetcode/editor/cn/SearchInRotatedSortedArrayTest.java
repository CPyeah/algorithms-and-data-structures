package leetcode.editor.cn;

import leetcode.editor.cn.SearchInRotatedSortedArray.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

	@Test
	public void test() {
		Solution solution = new SearchInRotatedSortedArray().new Solution();
		Assert.assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
	}

}
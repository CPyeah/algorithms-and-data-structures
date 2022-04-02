package leetcode.editor.cn;

import java.util.List;
import leetcode.editor.cn.PermutationsIi.Solution;
import org.junit.Assert;
import org.junit.Test;

public class PermutationsIiTest {

	@Test
	public void test() {
		Solution solution = new PermutationsIi().new Solution();
		List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
		Assert.assertEquals(3, lists.size());
	}

}
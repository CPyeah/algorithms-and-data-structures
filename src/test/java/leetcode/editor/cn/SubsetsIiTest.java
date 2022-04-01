package leetcode.editor.cn;

import java.util.List;
import leetcode.editor.cn.SubsetsIi.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SubsetsIiTest {

	@Test
	public void test() {
		Solution solution = new SubsetsIi().new Solution();
		List<List<Integer>> lists = solution.subsetsWithDup(new int[]{1, 2, 2});
		Assert.assertEquals(6, lists.size());
	}

}
package leetcode.editor.cn;

import java.util.List;
import leetcode.editor.cn.Subsets.Solution;
import leetcode.editor.cn.Subsets.Solution2;
import org.junit.Assert;
import org.junit.Test;

public class SubsetsTest {


	@Test
	public void test() {
		Solution solution = new Subsets().new Solution();
		List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
		Assert.assertEquals(8, subsets.size());
	}

	@Test
	public void test2() {
		Solution2 solution = new Subsets().new Solution2();
		List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
		Assert.assertEquals(8, subsets.size());
	}

}
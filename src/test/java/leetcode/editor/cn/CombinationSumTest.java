package leetcode.editor.cn;

import java.util.List;
import leetcode.editor.cn.CombinationSum.Solution;
import org.junit.Assert;
import org.junit.Test;

public class CombinationSumTest {

	@Test
	public void test() {
		//输入：candidates = [2,3,6,7], target = 7
		//输出：[[2,2,3],[7]]
		Solution solution = new CombinationSum().new Solution();
		List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
		Assert.assertEquals(2, lists.size());
	}

}
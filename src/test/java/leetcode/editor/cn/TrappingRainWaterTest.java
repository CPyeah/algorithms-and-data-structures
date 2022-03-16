package leetcode.editor.cn;

import leetcode.editor.cn.TrappingRainWater.Solution;
import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {

	@Test
	public void test() {
		Solution solution = new TrappingRainWater().new Solution();
		int result = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
		Assert.assertEquals(6, result);
	}

}
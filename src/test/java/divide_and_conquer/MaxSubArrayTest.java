package divide_and_conquer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxSubArrayTest {

	private static MaxSubArray.Solution1 solution1;
	private static MaxSubArray.Solution2 solution2;
	private static MaxSubArray.Solution3 solution3;


	@BeforeClass
	public static void setup() {
		solution1 = new MaxSubArray.Solution1();
		solution2 = new MaxSubArray.Solution2();
		solution3 = new MaxSubArray.Solution3();
	}

	@Test
	public void test1() {
		Assert.assertEquals(6, solution1.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		Assert.assertEquals(1, solution1.maxSubArray(new int[]{1}));
		Assert.assertEquals(23, solution1.maxSubArray(new int[]{5,4,-1,7,8}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(6, solution2.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		Assert.assertEquals(1, solution2.maxSubArray(new int[]{1}));
		Assert.assertEquals(23, solution2.maxSubArray(new int[]{5,4,-1,7,8}));
	}

	@Test
	public void test3() {
		Assert.assertEquals(6, solution3.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		Assert.assertEquals(1, solution3.maxSubArray(new int[]{1}));
		Assert.assertEquals(23, solution3.maxSubArray(new int[]{5,4,-1,7,8}));
	}
}
package greedy;

import greedy.BuyAndSellStock.Solution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuyAndSellStockTest {

	BuyAndSellStock.Solution solution;

	@Before
	public void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	public void test1() {
		Assert.assertEquals(7, solution.maxProfit(new int[]{7,1,5,3,6,4}));
		Assert.assertEquals(4, solution.maxProfit(new int[]{1,2,3,4,5}));
		Assert.assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
	}
}
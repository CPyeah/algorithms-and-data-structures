package DP;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoinChangeTest {

	private static CoinChange.Solution1 solution1;
	private static CoinChange.Solution2 solution2;


	@BeforeClass
	public static void setup() {
		solution1 = new CoinChange.Solution1();
		solution2 = new CoinChange.Solution2();
	}

	@Test
	public void test1() {
		Assert.assertEquals(5, solution1.coinChange(new int[]{2, 5, 7}, 27));
		Assert.assertEquals(3, solution1.coinChange(new int[]{1, 2, 5}, 11));
		Assert.assertEquals(-1, solution1.coinChange(new int[]{2}, 3));
		Assert.assertEquals(0, solution1.coinChange(new int[]{1}, 0));
		Assert.assertEquals(1, solution1.coinChange(new int[]{1}, 1));
		Assert.assertEquals(2, solution1.coinChange(new int[]{1}, 2));
	}

	@Test
	public void test2() {
		Assert.assertEquals(5, solution2.coinChange(new int[]{2, 5, 7}, 27));
		Assert.assertEquals(3, solution2.coinChange(new int[]{1, 2, 5}, 11));
		Assert.assertEquals(-1, solution2.coinChange(new int[]{2}, 3));
		Assert.assertEquals(0, solution2.coinChange(new int[]{1}, 0));
		Assert.assertEquals(1, solution2.coinChange(new int[]{1}, 1));
		Assert.assertEquals(2, solution2.coinChange(new int[]{1}, 2));
	}

}
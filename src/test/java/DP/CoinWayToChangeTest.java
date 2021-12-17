package DP;

import DP.CoinWayToChange.Solution1;
import DP.CoinWayToChange.Solution2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinWayToChangeTest {

	CoinWayToChange.Solution1 solution1;
	CoinWayToChange.Solution2 solution2;

	@Before
	public void setUp() throws Exception {
		solution1 = new Solution1();
		solution2 = new Solution2();
	}

	@Test
	public void test1() {
		Assert.assertEquals(2, solution1.way2Change(5));
		Assert.assertEquals(4, solution1.way2Change(10));
	}

	@Test
	public void test2() {
		System.out.println(solution2.way2Change(97));
		Assert.assertEquals(2, solution2.way2Change(5));
		Assert.assertEquals(4, solution2.way2Change(10));

	}
}
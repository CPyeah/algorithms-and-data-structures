package backtracking;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NQueensTest {

	private static NQueens.Solution1 solution1;


	@BeforeClass
	public static void setup() {
		solution1 = new NQueens.Solution1();
	}

	/**
	 * https://leetcode-cn.com/problems/n-queens/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
	 */
	@Test
	public void test1() {
		Assert.assertEquals(1, solution1.solveNQueens(1).size());
		Assert.assertEquals(0, solution1.solveNQueens(2).size());
		Assert.assertEquals(0, solution1.solveNQueens(3).size());
		Assert.assertEquals(2, solution1.solveNQueens(4).size());
		Assert.assertEquals(10, solution1.solveNQueens(5).size());
		Assert.assertEquals(4, solution1.solveNQueens(6).size());
		Assert.assertEquals(40, solution1.solveNQueens(7).size());
		Assert.assertEquals(92, solution1.solveNQueens(8).size());
		Assert.assertEquals(352, solution1.solveNQueens(9).size());
		Assert.assertEquals(724, solution1.solveNQueens(10).size());
		Assert.assertEquals(2680, solution1.solveNQueens(11).size());
		Assert.assertEquals(14200, solution1.solveNQueens(12).size());
		Assert.assertEquals(73712, solution1.solveNQueens(13).size());
	}

}
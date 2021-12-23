package backtracking;

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
		solution1.solveNQueens(8);
	}

}
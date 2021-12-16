package basic_concepts;

import DP.ClimbingStairs1;
import DP.ClimbingStairs1.Solution1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import recursion.ClimbingStairs;

public class ClimbingStairsTest {

	ClimbingStairs climbingStairs = new ClimbingStairs();
	ClimbingStairs1.Solution1 solution1;

	@Before
	public void setup() {
		solution1 = new Solution1();
	}

	/**
	 * n = 2;   1 1  /  2   -> 2
	 * <p>
	 * n = 3;   1 1 1 / 1 2 / 2 1  -> 3
	 * <p>
	 * n = 4;   1 1 1 1 / 1 1 2 / 1 2 1 / 2 1 1 / 2 2  -> 5
	 * <p>
	 * ......
	 */
	@Test
	public void solution() {
		Assert.assertEquals(2, climbingStairs.solution(2));
		Assert.assertEquals(3, climbingStairs.solution(3));
		Assert.assertEquals(5, climbingStairs.solution(4));
		Assert.assertEquals(21, climbingStairs.solution(7));
		Assert.assertEquals(55, climbingStairs.solution(9));
	}

	@Test
	public void solution1() {
		Assert.assertEquals(2, solution1.climbingStairs(2));
		Assert.assertEquals(3, solution1.climbingStairs(3));
		Assert.assertEquals(5, solution1.climbingStairs(4));
		Assert.assertEquals(21, solution1.climbingStairs(7));
		Assert.assertEquals(55, solution1.climbingStairs(9));
	}
}
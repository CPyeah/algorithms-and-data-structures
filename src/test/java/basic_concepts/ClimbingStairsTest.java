package basic_concepts;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ClimbingStairsTest {

	ClimbingStairs climbingStairs = new ClimbingStairs();

	/**
	 * n = 2;   1 1  /  2   -> 2
	 * n = 3;   1 1 1 / 1 2 / 2 1  -> 3
	 * n = 4;   1 1 1 1 / 1 1 2 / 1 2 1 / 2 1 1 / 2 2  -> 5
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
}
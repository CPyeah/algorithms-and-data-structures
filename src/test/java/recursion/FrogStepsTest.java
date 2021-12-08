package recursion;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import recursion.FrogSteps.Solution1;
import recursion.FrogSteps.Solution2;

public class FrogStepsTest {

	private static FrogSteps.Solution1 solution1;
	private static FrogSteps.Solution2 solution2;


	@BeforeClass
	public static void setup() {
		solution1 = new FrogSteps.Solution1();
		solution2 = new FrogSteps.Solution2();
	}

	@Test
	public void test1() {
		Assert.assertEquals(2, solution1.frogSteps(2));
		Assert.assertEquals(2, solution1.frogSteps(2));
		Assert.assertEquals(3, solution1.frogSteps(3));
		Assert.assertEquals(5, solution1.frogSteps(4));
		Assert.assertEquals(21, solution1.frogSteps(7));
		Assert.assertEquals(55, solution1.frogSteps(9));
	}


	@Test
	public void test2() {
		Assert.assertEquals(2, solution2.frogSteps(2));
		Assert.assertEquals(2, solution2.frogSteps(2));
		Assert.assertEquals(3, solution2.frogSteps(3));
		Assert.assertEquals(5, solution2.frogSteps(4));
		Assert.assertEquals(21, solution2.frogSteps(7));
		Assert.assertEquals(55, solution2.frogSteps(9));
	}

	@Test
	public void test3() {
		for (int i = 0; i < 17; i++) {
			Solution1 solution1 = new Solution1();
			solution1.frogSteps(i);
			System.out.println(solution1.count);
		}
		for (int i = 0; i < 17; i++) {
			Solution2 solution2 = new Solution2();
			solution2.frogSteps(i);
			System.out.println(solution2.count);
		}
	}

}
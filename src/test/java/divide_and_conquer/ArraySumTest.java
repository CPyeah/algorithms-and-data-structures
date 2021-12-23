package divide_and_conquer;

import java.util.concurrent.ExecutionException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.CommonUtils;

public class ArraySumTest {

	private static ArraySum.Solution1 solution1;
	private static ArraySum.Solution2 solution2;
	private static ArraySum.Solution3 solution3;


	@BeforeClass
	public static void setup() {
		solution1 = new ArraySum.Solution1();
		solution2 = new ArraySum.Solution2();
		solution3 = new ArraySum.Solution3();
	}

	@Test
	public void test1() {
		int[] array = CommonUtils.randomIntArrayGenerator0(20);
		int sum = solution1.arraySum(array);
		System.out.println(sum);
	}

	@Test
	public void test2() {
		int[] array = CommonUtils.randomIntArrayGenerator0(20);
		int sum = solution1.arraySum(array);
		System.out.println(sum);
		Assert.assertEquals(sum, solution2.arraySum(array));
	}

	@Test
	public void test3() throws ExecutionException, InterruptedException {
		int[] array = CommonUtils.randomIntArrayGenerator0(20);
		int sum = solution1.arraySum(array);
		System.out.println(sum);
		Assert.assertEquals(sum, solution3.arraySum(array));
	}
}
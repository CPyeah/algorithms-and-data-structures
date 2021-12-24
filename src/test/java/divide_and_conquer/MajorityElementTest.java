package divide_and_conquer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MajorityElementTest {

	private static MajorityElement.Solution1 solution1;


	@BeforeClass
	public static void setup() {
		solution1 = new MajorityElement.Solution1();
	}

	@Test
	public void test1() {
		Assert.assertEquals(2, solution1.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
	}

}
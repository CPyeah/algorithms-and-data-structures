package recursion;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SumListTest {

	private static SumList.Solution1 solution1;

	@BeforeClass
	public static void setup() {
		solution1 = new SumList.Solution1();
	}

	@Test
	public void test1() {
		int sum = solution1.sumList(Lists.newArrayList(1, 2, 3, 4, 5, 6));
		Assert.assertEquals(21, sum);
	}

}
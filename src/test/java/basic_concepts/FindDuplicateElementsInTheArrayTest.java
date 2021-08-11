package basic_concepts;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindDuplicateElementsInTheArrayTest {

	private static FindDuplicateElementsInTheArray find;

	@BeforeClass
	public static void setup() {
		find = new FindDuplicateElementsInTheArray();
	}

	@Test
	public void test1() {
		int[] array = {1, 2, 6, 5, 4, 2, 6};
		int[] duplication = find.solution1(array);
		Assert.assertArrayEquals(new int[]{2, 6}, duplication);

	}

	@Test
	public void test2() {
		int[] array = { 1, 2, 3, 1, 3, 6, 6 };
		int[] duplication = find.solution2(array);
		Assert.assertArrayEquals(new int[]{1, 3, 6}, duplication);

	}
}
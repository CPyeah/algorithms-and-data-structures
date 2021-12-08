package basic_concepts;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {

	private static BinarySearch.Solution1 solution1;
	private static BinarySearch.Solution2 solution2;

	@BeforeClass
	public static void setup() {
		solution1 = new BinarySearch.Solution1();
		solution2 = new BinarySearch.Solution2();
	}

	@Test
	public void test1() {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20};
		Assert.assertEquals(3, solution1.binarySearch(array, 4));
		Assert.assertEquals(8, solution1.binarySearch(array, 9));
		Assert.assertEquals(14, solution1.binarySearch(array, 16));
		Assert.assertEquals(-1, solution1.binarySearch(array, 13));
	}

	@Test
	public void test2() {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20};
		Assert.assertEquals(3, solution2.binarySearch(array, 4));
		Assert.assertEquals(8, solution2.binarySearch(array, 9));
		Assert.assertEquals(14, solution2.binarySearch(array, 16));
		Assert.assertEquals(-1, solution2.binarySearch(array, 13));
	}
}
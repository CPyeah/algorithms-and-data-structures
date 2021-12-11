package sortings;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTest {

	private static QuickSort.Solution1 solution1;
	private static QuickSort.Solution2 solution2;


	@BeforeClass
	public static void setup() {
		solution1 = new QuickSort.Solution1();
		solution2 = new QuickSort.Solution2();
	}

	@Test
	public void solution1() {
		int[] array = SortUtils.getRandomArray();
		int[] expect = SortUtils.sortArray(array);
		int[] result = solution1.quickSort(array);

		System.out.println("array is " + Arrays.toString(array));
		System.out.println("sorted array is " + Arrays.toString(result));

		Assert.assertArrayEquals(expect, result);
	}

	@Test
	public void solution2() {
		int[] array = SortUtils.getRandomArray();
		int[] expect = SortUtils.sortArray(array);
		int[] result = solution2.quickSort(array);

		System.out.println("array is " + Arrays.toString(array));
		System.out.println("sorted array is " + Arrays.toString(result));

		Assert.assertArrayEquals(expect, result);
	}
}
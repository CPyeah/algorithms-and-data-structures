package sortings;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void solution() {
		int[] array = SortUtils.getRandomArray();
		int[] expect = SortUtils.sortArray(array);
		new BubbleSort().solution(array);
		Assert.assertArrayEquals(expect, array);
	}
}
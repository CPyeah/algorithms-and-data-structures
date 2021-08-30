package basic_concepts;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

	BinarySearch binarySearch = new BinarySearch();

	@Test
	public void solution() {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20};
		Assert.assertEquals(3, binarySearch.solution(array, 4));
		Assert.assertEquals(8, binarySearch.solution(array, 9));
		Assert.assertEquals(14, binarySearch.solution(array, 16));
		Assert.assertEquals(-1, binarySearch.solution(array, 13));
	}
}
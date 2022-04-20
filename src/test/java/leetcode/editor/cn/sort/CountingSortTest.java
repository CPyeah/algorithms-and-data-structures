package leetcode.editor.cn.sort;

import java.util.Arrays;
import leetcode.editor.cn.SortUtils;
import leetcode.editor.cn.sort.CountingSort.Solution;
import org.junit.Assert;
import org.junit.Test;

public class CountingSortTest {

	@Test
	public void test0() {
		Solution solution = new Solution();
		int[] sort = solution.sort(new int[]{5, 3, 3, 2, 6, 7, 8, 9, 0, 4}, 10);
		System.out.println(Arrays.toString(sort));
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums = SortUtils.getRandomArray();
		int[] sorted = SortUtils.sortArray(nums);
		int[] result = solution.sort(nums, 50);
		Assert.assertEquals(Arrays.toString(sorted), Arrays.toString(result));
	}

}
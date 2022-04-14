package leetcode.editor.cn.sort;

import java.util.Arrays;
import leetcode.editor.cn.SortUtils;
import leetcode.editor.cn.sort.QuickSort.Solution;
import leetcode.editor.cn.sort.QuickSort.Solution2;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums = SortUtils.getRandomArray();
		int[] sorted = SortUtils.sortArray(nums);
		int[] result = solution.sort(nums);
		Assert.assertEquals(Arrays.toString(sorted), Arrays.toString(result));
	}

	@Test
	public void test2() {
		Solution2 solution = new Solution2();
		int[] nums = SortUtils.getRandomArray();
		int[] sorted = SortUtils.sortArray(nums);
		int[] result = solution.sort(nums);
		Assert.assertEquals(Arrays.toString(sorted), Arrays.toString(result));
	}

}
package leetcode.editor.cn.sort;

import java.util.Arrays;
import leetcode.editor.cn.SortUtils;
import leetcode.editor.cn.sort.InsertionSort.Solution;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums = SortUtils.getRandomArray();
		int[] sorted = SortUtils.sortArray(nums);
		int[] result = solution.sort(nums);
		Assert.assertEquals(Arrays.toString(sorted), Arrays.toString(result));
	}

}
package leetcode.editor.cn.sort;

public class SortUtil {

	protected static void swap(int[] nums, int a, int b) {
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}

}

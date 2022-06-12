package leetcode.editor.cn.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快速排序
 */
public class QuickSort {

	// in-place
	public static class Solution2 {

		public int[] sort(int[] nums) {
			sort(nums, 0, nums.length - 1);
			return nums;
		}

		private void sort(int[] nums, int left, int right) {
			if (left >= right) {
				return;
			}
			int pivotIndex = pivotDivision(nums, left, right);

			sort(nums, left, pivotIndex - 1);
			sort(nums, pivotIndex + 1, right);
		}

		// 按照基准  左右划分
		// 3  2  6  5  4
		// 3  2  4  6  5
		private int pivotDivision(int[] nums, int left, int right) {
			// 默认给最右边的值 为基准
			int pivot = nums[right];
			// 初始化，基准Index
			int pivotIndex = left;
			// 把子数组遍历一遍
			for (int i = left; i < right; i++) {
				// 如果比 基准小  替换到前面  基准Index++
				if (nums[i] <= pivot) {
					SortUtil.swap(nums, i, pivotIndex);
					pivotIndex++;
				}
			}
			// 最后再把 基准放到中间来
			SortUtil.swap(nums, right, pivotIndex);

			return pivotIndex;
		}
	}

	/**
	 * 使用List，带辅助空间
	 */
	public static class Solution {

		public int[] sort(int[] nums) {
			List<Integer> list = quickSort(
					Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return list.stream().mapToInt(i -> i).toArray();
		}

		// 快速排序递归方法
		private List<Integer> quickSort(List<Integer> list) {
			// 递归出口
			if (list.size() < 2) {
				return list;
			}
			// 随便找一个基准，这里取的是第一个元素
			Integer pivot = list.get(0);

			// 辅助空间
			List<Integer> low = new ArrayList<>();
			List<Integer> high = new ArrayList<>();
			List<Integer> equal = new ArrayList<>();

			// 结果集合
			List<Integer> sorted = new ArrayList<>();

			// 大于基准的集合；小于基准的集合；等于基准的集合
			for (Integer item : list) {
				if (item.equals(pivot)) {
					equal.add(item);
				} else if (item < pivot) {
					low.add(item);
				} else {
					high.add(item);
				}
			}
			// 递归
			low = quickSort(low);
			high = quickSort(high);

			// 合并
			sorted.addAll(low);
			sorted.addAll(equal);
			sorted.addAll(high);
			return sorted;
		}
	}

}

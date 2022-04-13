package leetcode.editor.cn.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快速排序
 */
public class QuickSort {

	public static class Solution {

		public int[] sort(int[] nums) {
			List<Integer> list = quickSort(
					Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return list.stream().mapToInt(i -> i).toArray();
		}

		private List<Integer> quickSort(List<Integer> list) {
			if (list.size() < 2) {
				return list;
			}
			Integer pivot = list.get(0);
			List<Integer> low = new ArrayList<>();
			List<Integer> high = new ArrayList<>();
			List<Integer> equal = new ArrayList<>();
			List<Integer> sorted = new ArrayList<>();
			for (Integer item : list) {
				if (item.equals(pivot)) {
					equal.add(item);
				} else if (item < pivot) {
					low.add(item);
				} else {
					high.add(item);
				}
			}
			low = quickSort(low);
			high = quickSort(high);
			sorted.addAll(low);
			sorted.addAll(equal);
			sorted.addAll(high);
			return sorted;
		}
	}

}

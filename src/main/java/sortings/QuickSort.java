package sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 快速排序
 * <p>
 * https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F
 */
public class QuickSort {

	// with space
	public static class Solution1 {

		public int[] quickSort(int[] arr) {
			List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
			List<Integer> sorted = sort(arrayList);
			return sorted.stream().mapToInt(Integer::valueOf).toArray();
		}

		public List<Integer> sort(List<Integer> arrayList) {
			if (CollectionUtils.isEmpty(arrayList)) {
				return arrayList;
			}
			Integer pivot = arrayList.get(0);
			ArrayList<Integer> less = new ArrayList<>();
			ArrayList<Integer> pivotList = new ArrayList<>();
			ArrayList<Integer> greater = new ArrayList<>();
			arrayList.forEach(a -> {
				if (a.compareTo(pivot) < 0) {
					less.add(a);
				} else if (a.equals(pivot)) {
					pivotList.add(a);
				} else {
					greater.add(a);
				}
			});

			ArrayList<Integer> result = new ArrayList<>();
			result.addAll(sort(less));
			result.addAll(pivotList);
			result.addAll(sort(greater));
			return result;
		}

	}

	// in-place
	public static class Solution2 {

		public int[] quickSort(int[] arr) {
			return null;
		}

	}

}

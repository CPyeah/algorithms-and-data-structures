package recursion;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 数组求和（递归）
 */
public class SumList {

	public static class Solution1 {

		public int sumList(List<Integer> list) {
			if (CollectionUtils.isEmpty(list)) {
				return 0;
			}
			return list.get(0) + sumList(list.subList(1, list.size()));
		}

	}

}

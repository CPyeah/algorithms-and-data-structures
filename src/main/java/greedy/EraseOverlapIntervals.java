package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * <p>
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠
 * <p>
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class EraseOverlapIntervals {

	public static class Solution1 {

		public int eraseOverlapIntervals(int[][] intervals) {
			// 按照右端点 排序
			Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
			// 看是否有重合
			int[] current = intervals[0];
			int count = 0;
			for (int i = 1; i < intervals.length; i++) {
				if (isOverlapping(current, intervals[i])) {
					++count;
				} else {
					current = intervals[i];
				}
			}
			return count;
		}

		private boolean isOverlapping(int[] current, int[] interval) {
			return interval[0] < current[1];
		}
	}

}

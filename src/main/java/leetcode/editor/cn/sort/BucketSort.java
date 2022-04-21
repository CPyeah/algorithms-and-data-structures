package leetcode.editor.cn.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// 桶排序
// 1、 定义桶
// 2、 按桶，对数组分组
// 3、 对每个桶进行排序
// 4、 组合每个桶
public class BucketSort {

	public static class Solution {

		public int[] sort(int[] nums) {

			// 1、 定义桶
			int maxValue = nums[0], minValue = nums[0];
			for (int v : nums) {
				maxValue = Math.max(maxValue, v); // 47
				minValue = Math.min(minValue, v); // 1
			}

			// 桶对数量（不重要，大概就行）
			int bucketCount = (int) Math.sqrt(nums.length); // 8
			List<Integer>[] buckets = new List[bucketCount];
			// 2、 按桶，对数组分组
			for (int v : nums) { // v =15
				// 找到对应对桶，这点要注意
				int bucketIndex = v * (bucketCount - 1) / maxValue;
				List<Integer> bucket = buckets[bucketIndex];
				if (bucket == null) {
					bucket = new ArrayList<>();
					bucket.add(v);
					buckets[bucketIndex] = bucket;
				} else {
					bucket.add(v);
				}
			}
			// 3、 对每个桶进行排序
			for (List<Integer> bucket : buckets) {
				Collections.sort(bucket);
			}
			// 4、 组合每个桶
			return Arrays.stream(buckets).flatMap(Collection::stream)
					.mapToInt(Integer::intValue).toArray();
		}
	}

}

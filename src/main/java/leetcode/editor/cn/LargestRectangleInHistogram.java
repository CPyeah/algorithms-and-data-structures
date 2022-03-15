package leetcode.editor.cn;

/**
 * [84] 柱状图中最大的矩形
 */
public class LargestRectangleInHistogram {


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// 暴力解
		// 找每一个条，往左右延伸的最大的矩形
		public int largestRectangleArea(int[] heights) {
			int maxArea = 0;

			return maxArea;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	class Solution2 {

		// 暴力解  会超时
		// 找每一个条，往左右延伸的最大的矩形
		public int largestRectangleArea(int[] heights) {
			int maxArea = 0;
			for (int i = 0; i < heights.length; i++) {
				int left = i, right = i;
				int tail = heights[i];
				for (int j = i; j >= 0; j--) {
					if (heights[j] >= tail) {
						left = j;
					} else {
						break;
					}
				}
				for (int j = i; j < heights.length; j++) {
					if (heights[j] >= tail) {
						right = j;
					} else {
						break;
					}
				}
				int width = right - left + 1;
				int area = width * tail;
				maxArea = Math.max(maxArea, area);
			}
			return maxArea;
		}
	}
}
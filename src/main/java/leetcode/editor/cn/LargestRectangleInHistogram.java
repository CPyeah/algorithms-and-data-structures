package leetcode.editor.cn;

import java.util.Stack;

/**
 * [84] 柱状图中最大的矩形
 */
public class LargestRectangleInHistogram {


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// 单调栈
		public int largestRectangleArea(int[] heights) {
			int maxArea = 0;
			// 存的是heights的索引
			Stack<Integer> stack = new Stack<>();
			stack.push(0);

			// 哨兵处理   前后加 0
			int[] newHeights = new int[heights.length + 2];
			newHeights[0] = 0;
			System.arraycopy(heights, 0, newHeights, 1, heights.length);
			newHeights[newHeights.length - 1] = 0;

			// 0, 2, 1, 5, 6, 2, 3, 0
			// 0, 1, 2, 3, 4, 5, 6, 7

			// 0, 2, 1, 2, 0
			// 0, 1, 2, 3, 4
			for (int i = 0; i < newHeights.length; i++) {

				while (isSmallThanTop(newHeights, i, stack)) {
					// 一定要先出栈
					int high = newHeights[stack.pop()];
					int width = i - stack.peek() - 1;
					maxArea = Math.max(maxArea, high * width);
				}

				stack.push(i);

			}

			return maxArea;
		}

		private boolean isSmallThanTop(int[] heights, int i, Stack<Integer> stack) {
			return heights[i] < heights[stack.peek()];
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
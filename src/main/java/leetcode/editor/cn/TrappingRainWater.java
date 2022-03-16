package leetcode.editor.cn;

import java.util.Stack;

/**
 * [42] 接雨水
 */
public class TrappingRainWater {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int trap(int[] height) {
			// 单调递减栈、存放的是索引
			Stack<Integer> stack = new Stack<>();
			// 雨水的容积
			int water = 0;

			for (int i = 0; i < height.length; i++) {
				// 当前高度 比 栈顶高度 高, 计算雨水
				while (!stack.isEmpty() && isBiggerThanTop(height, i, stack)) {
					// 右墙索引，就是当前索引
					int rightIndex = i;
					// 低洼处 索引
					int bottomIndex = stack.pop();
					// 如果没有左墙
					if (stack.isEmpty()) {
						break;
					}
					// 左墙索引
					int leftIndex = stack.peek();

					// 水的宽度 = 右墙位置 - 左墙位置 -1
					int width = rightIndex - leftIndex - 1;

					// 实际水的高度 = min（左墙高度，右墙高度） - 低洼处高度
					int high =
							Math.min(height[leftIndex], height[rightIndex]) - height[bottomIndex];

					water += width * high;

				}
				stack.push(i);
			}

			return water;
		}

		private boolean isBiggerThanTop(int[] height, int i, Stack<Integer> stack) {
			return height[i] > height[stack.peek()];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
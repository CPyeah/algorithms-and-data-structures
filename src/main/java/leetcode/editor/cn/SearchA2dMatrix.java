package leetcode.editor.cn;

/**
 * [74] 搜索二维矩阵
 */
public class SearchA2dMatrix {


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		//  1  3  5  7
		// 10 11 16 20
		// 23 30 34 60
		public boolean searchMatrix(int[][] matrix, int target) {
			Point left = new Point(0, 0);
			Point right = new Point(matrix[0].length - 1, matrix.length - 1);
			while (true) {
				if (left.value(matrix) == target || right.value(matrix) == target) {
					return true;
				}
				Point mid = getMiddlePoint(left, right, matrix[0].length);
				if (mid.value(matrix) == target) {
					return true;
				}
				if (left.equals(mid) || right.equals(mid)) {
					return false;
				}
				if (target < mid.value(matrix)) {
					right = mid;
				} else {
					left = mid;
				}
			}
		}

		// 找到中间点
		private Point getMiddlePoint(Point left, Point right, int width) {
			// 两点相聚距离
			int len = (right.y - left.y) * width + (right.x - left.x);
			// 中间点即为  leftPoint + (len / 2)
			int tempX = left.x + len / 2;
			int y = left.y + tempX / width;
			int x = tempX % width;
			return new Point(x, y);
		}

		class Point {

			int x;
			int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			int value(int[][] matrix) {
				return matrix[y][x];
			}

			boolean equals(Point p) {
				return this.x == p.x && this.y == p.y;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
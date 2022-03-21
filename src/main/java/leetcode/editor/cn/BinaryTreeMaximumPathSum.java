package leetcode.editor.cn;

import java.util.Arrays;
import model.TreeNode;

/**
 * [124] 二叉树中的最大路径和
 */
public class BinaryTreeMaximumPathSum {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		long maxVal = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			return (int) Math.max(getMax(root), maxVal);
		}

		private long getMax(TreeNode node) {
			if (node == null) {
				return Integer.MIN_VALUE;
			}
			long rootVal = node.val;
			long leftVal = getMax(node.left);
			long rightVal = getMax(node.right);
			// 左、 右、 左根右   无法继续向上链接，判断当前最大值
			maxVal = max(maxVal, leftVal, rightVal, leftVal + rootVal + rightVal);
			// 根、 左根、 右根 可以继续向上链接， 取最大值返回
			return max(rootVal, leftVal + rootVal, rightVal + rootVal);
		}

		private long max(long... nums) {
			return Arrays.stream(nums).max().getAsLong();
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
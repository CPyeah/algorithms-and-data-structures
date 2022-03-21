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

		int maxVal = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			getMax(root);
			return maxVal;
		}

		private int getMax(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int rootVal = node.val;
			int leftVal = getMax(node.left);
			int rightVal = getMax(node.right);
			// 根、 左根、 右根 可以继续向上链接， 取最大值返回
			int retVal = max(rootVal, leftVal + rootVal, rightVal + rootVal);
			// 左根右   无法继续向上链接，判断当前最大值
			maxVal = max(maxVal, leftVal + rootVal + rightVal, retVal);
			return retVal;
		}

		private int max(int... nums) {
			return Arrays.stream(nums).max().getAsInt();
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
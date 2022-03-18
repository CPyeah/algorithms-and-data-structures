package leetcode.editor.cn;

import model.TreeNode;

/**
 * [110] 平衡二叉树
 */
public class BalancedBinaryTree {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public boolean isBalanced(TreeNode root) {
			return deep(root) != -1;
		}

		// 返回 -1 表示不平衡    自然数表示数高
		private int deep(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int left = deep(node.left);
			int right = deep(node.right);
			// 不平衡的情况
			if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
				return -1;
			}
			// 当前树高
			return Math.max(left, right) + 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
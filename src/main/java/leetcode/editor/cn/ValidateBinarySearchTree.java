package leetcode.editor.cn;

import model.TreeNode;

/**
 * [98] 验证二叉搜索树
 */
public class ValidateBinarySearchTree {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public boolean isValidBST(TreeNode root) {
			return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}

		/**
		 * 判断当前节点是不是二叉搜索树， 注意递归公式的写法
		 *
		 * @param node 当前节点
		 * @param min  范围左边界
		 * @param max  范围右边界
		 * @return 是/否
		 */
		private boolean isBST(TreeNode node, long min, long max) {
			if (node == null) {
				return true;
			}
			// 判断当前节点满足不满足条件
			if (node.val <= min || node.val >= max) {
				return false;
			}
			// 看左节点是否满足条件  要比当前节点的值小
			boolean leftIs = isBST(node.left, min, node.val);
			// 再看右节点是否满足条件
			boolean rightIs = isBST(node.right, node.val, max);
			return leftIs && rightIs;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
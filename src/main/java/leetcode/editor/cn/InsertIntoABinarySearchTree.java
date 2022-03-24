package leetcode.editor.cn;

import model.TreeNode;

/**
 * [701] 二叉搜索树中的插入操作
 */
public class InsertIntoABinarySearchTree {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public TreeNode insertIntoBST(TreeNode root, int val) {
			if (root == null) {
				return new TreeNode(val);
			}
			findAndInsertNode(root, val);
			return root;
		}

		private void findAndInsertNode(TreeNode pointer, int val) {
			if (val < pointer.val) {
				if (pointer.left == null) {
					pointer.left = new TreeNode(val);
				} else {
					findAndInsertNode(pointer.left, val);
				}
			}
			if (val > pointer.val) {
				if (pointer.right == null) {
					pointer.right = new TreeNode(val);
				} else {
					findAndInsertNode(pointer.right, val);
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
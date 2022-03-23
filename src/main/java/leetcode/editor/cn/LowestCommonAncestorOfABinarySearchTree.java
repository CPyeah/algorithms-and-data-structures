package leetcode.editor.cn;

import model.TreeNode;

/**
 * [235] 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorOfABinarySearchTree {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode(int x) { val = x; } }
	 */

	class Solution {

		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			// 退出条件
			if (root == null) {
				return null;
			}
			if (root == p || root == q) {
				return root;
			}
			// 分治、递归
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			// 结果判断
			// 找最小父节点
			// 如果左右两边都没有，那就是没有了
			// 如果两个孩子在一边（左边），左边和根就都是父节点，取小的，返回左节点， 右边同理
			// 如果两个孩子各在一边， 那么根节点就是他们唯一的父节点
			if (left == null && right == null) {
				return null;
			}
			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			return right;
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
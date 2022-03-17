package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import model.TreeNode;

/**
 * [144] 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		Solution solution = new BinaryTreePreorderTraversal().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			preorderTraversal(root, result);
			return result;
		}

		private void preorderTraversal(TreeNode node, List<Integer> result) {
			if (node == null) {
				return;
			}
			result.add(node.val);
			preorderTraversal(node.left, result);
			preorderTraversal(node.right, result);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	// 递归
	class Solution2 {

		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			preorderTraversal(root, result);
			return result;
		}

		private void preorderTraversal(TreeNode node, List<Integer> result) {
			if (node == null) {
				return;
			}
			result.add(node.val);
			preorderTraversal(node.left, result);
			preorderTraversal(node.right, result);
		}
	}
}
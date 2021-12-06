package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.TreeNode;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

	public static class Solution1 {

		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			inorder(root, result);
			return result;
		}

		private void inorder(TreeNode root, List<Integer> result) {
			if (root == null) {
				return;
			}
			inorder(root.left, result);
			result.add(root.val);
			inorder(root.right, result);
		}

	}

	public static class Solution2 {

		//iterative approach
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			while (root != null || !stack.isEmpty()) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
			return result;
		}
	}

}

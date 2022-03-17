package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.TreeNode;

/**
 * [94] 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		// 左 根 右
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			TreeNode pointer = root;
			Stack<TreeNode> stack = new Stack<>();
			while (pointer != null || !stack.isEmpty()) {
				if (pointer != null) {
					stack.push(pointer);
					pointer = pointer.left;
				} else {
					TreeNode node = stack.pop();
					result.add(node.val);
					pointer = node.right;
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import model.TreeNode;

/**
 * [107] 二叉树的层序遍历 II
 */
public class BinaryTreeLevelOrderTraversalIi {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}

			LinkedList<List<Integer>> result = new LinkedList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				List<Integer> levelResult = new ArrayList<>();
				int levelSize = queue.size();
				for (int i = 0; i < levelSize; i++) {
					TreeNode node = queue.poll();
					levelResult.add(node.val);
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
				result.addFirst(levelResult);
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import model.TreeNode;

/**
 * [103] 二叉树的锯齿形层序遍历
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			Queue<TreeNode> queue = new LinkedList<>();
			List<List<Integer>> result = new ArrayList<>();

			queue.add(root);
			boolean orderFlag = true;

			while (!queue.isEmpty()) {
				int size = queue.size();
				LinkedList<Integer> tempResult = new LinkedList<>();
				// 遍历一层
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
					if (orderFlag) {
						tempResult.addLast(node.val);
					} else {
						tempResult.addFirst(node.val);
					}
				}
				orderFlag = !orderFlag;
				result.add(tempResult);
			}

			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
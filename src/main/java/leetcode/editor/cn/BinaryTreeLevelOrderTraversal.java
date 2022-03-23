package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import model.TreeNode;

/**
 * [102] 二叉树的层序遍历
 */
public class BinaryTreeLevelOrderTraversal {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null) {
				return new ArrayList<>();
			}
			Queue<TreeNode> queue = new LinkedList<>();
			List<List<Integer>> result = new ArrayList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				// 当前层次，在队列中的个数
				int size = queue.size();
				List<Integer> tempResult = new ArrayList<>();
				// 只出队列当前层次的节点，做结果保存
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					tempResult.add(node.val);
					// 如果有子节点，就加到队列中
					addSubNodesInQueue(queue, node);
				}
				result.add(tempResult);
			}
			return result;
		}

		// 如果有子节点，就加到队列中
		private void addSubNodesInQueue(Queue<TreeNode> queue, TreeNode node) {
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
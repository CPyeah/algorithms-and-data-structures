package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 二叉树的广度有限遍历
 */
public class BFS {

	public static class Solution1 {

		public List<Integer> bfs(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			LinkedList<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			bfs(result, queue);
			return result;
		}

		private void bfs(List<Integer> result, LinkedList<TreeNode> queue) {
			if (CollectionUtils.isEmpty(queue)) {
				return;
			}
			TreeNode root = queue.pop();
			result.add(root.val);
			if (root.left != null) {
				queue.add(root.left);
			}
			if (root.right != null) {
				queue.add(root.right);
			}
			bfs(result, queue);
		}


	}

}

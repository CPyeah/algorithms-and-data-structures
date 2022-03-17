package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.TreeNode;

/**
 * [145] 二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal {
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
	 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
	 */
	class Solution {

		// 左 - 右 - 根
		public List<Integer> postorderTraversal(TreeNode root) {
			TreeNode p = root;
			TreeNode visited = root;
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			while (p != null || !stack.isEmpty()) {
				// 左节点压入栈
				while (p != null) {
					stack.push(p);
					p = p.left;
				}
				p = stack.peek();
				// 可记录，如果右节点为空，或者右节点已经访问过
				if(p.right == null || p.right == visited) {
					result.add(p.val);
					stack.pop();
					visited = p;
					p = null;
				} else {
					p = p.right;
				}
			}
			return result;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
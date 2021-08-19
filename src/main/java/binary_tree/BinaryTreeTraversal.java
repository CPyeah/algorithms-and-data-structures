package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.BinaryNode;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {

	// root left right
	public List<Integer> preOrderTraverse(BinaryNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		preOrderTraverse(root, result);
		return result;
	}

	private void preOrderTraverse(BinaryNode root, ArrayList<Integer> result) {
		if (root != null) {
			result.add(root.val);
			preOrderTraverse(root.left, result);
			preOrderTraverse(root.right, result);
		}
	}

	// left  root  right
	public List<Integer> inOrderTraverse(BinaryNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		inOrderTraverse(root, result);
		return result;
	}

	private void inOrderTraverse(BinaryNode root, ArrayList<Integer> result) {
		if (root != null) {
			inOrderTraverse(root.left, result);
			result.add(root.val);
			inOrderTraverse(root.right, result);
		}
	}

	// left  right  root
	public List<Integer> postOrderTraverse(BinaryNode root) {
		List<Integer> result = new ArrayList<>();
		postOrderTraverse(root, result);
		return result;
	}

	private void postOrderTraverse(BinaryNode root, List<Integer> result) {
		if (root != null) {
			postOrderTraverse(root.left, result);
			postOrderTraverse(root.right, result);
			result.add(root.val);
		}
	}

	// breadth first traverse
	public List<Integer> breadthFirstTraverse(BinaryNode root) {
		LinkedList<BinaryNode> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode node = queue.pollFirst();
			result.add(node.val);
			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}
		return result;
	}

}

package binary_tree;

import java.util.Arrays;
import java.util.List;
import model.TreeNode;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.CommonUtils;
import utils.TreeUtils;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversalTest {

	private static InorderTraversal.Solution1 solution1;
	private static InorderTraversal.Solution2 solution2;
	private static TreeNode root;
	private static List<Integer> inorder;

	@BeforeClass
	public static void setup() {
		solution1 = new InorderTraversal.Solution1();
		solution2 = new InorderTraversal.Solution2();
	}

	@Test
	public void test1() {
		root = TreeUtils.constructBinaryTree(Arrays.asList(3, 1, null, null, 5, 2, null, null, 4));
		inorder = solution1.inorderTraversal(root);
		CommonUtils.printList(inorder);
	}

	@Test
	public void test2() {
		root = TreeUtils.constructBinaryTree(
				Arrays.asList(1, 2, 3, 4, null, 5, 6, null, 7, null, null, null, null, 8, 9));
		TreeUtils.printBinaryTree(root);
		inorder = solution1.inorderTraversal(root);
		CommonUtils.printList(inorder);
	}

	@Test
	public void test3() {
		root = TreeUtils.constructBinaryTree(Arrays.asList(1, 2, 3, 4, null, 5, null, null, 6));
		TreeUtils.printBinaryTree(root);
		inorder = solution2.inorderTraversal(root);
		CommonUtils.printList(inorder);
	}

}
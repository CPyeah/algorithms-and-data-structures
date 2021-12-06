package binary_tree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import model.TreeNode;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.CommonUtils;
import utils.TreeUtils;

public class BFSTest {

	private static BFS.Solution1 solution1;
	private static TreeNode root;
	private static List<Integer> inorder;

	@BeforeClass
	public static void setup() {
		solution1 = new BFS.Solution1();
	}

	@Test
	public void test1() {
		root = TreeUtils.constructBinaryTree(Arrays.asList(3, 1, null, null, 5, 2, null, null, 4));
		TreeUtils.printBinaryTree(root);
		inorder = solution1.bfs(root);
		CommonUtils.printList(inorder);
	}

	@Test
	public void test2() {
		root = TreeUtils.constructBinaryTree(
				Arrays.asList(1, 2, 3, 4, null, 5, 6, null, 7, null, null, null, null, 8, 9));
		TreeUtils.printBinaryTree(root);
		inorder = solution1.bfs(root);
		CommonUtils.printList(inorder);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), inorder);
	}

}
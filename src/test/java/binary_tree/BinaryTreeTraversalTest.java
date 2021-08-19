package binary_tree;

import java.util.Arrays;
import java.util.List;
import model.BinaryNode;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTraversalTest {

	BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();

	@Test
	public void preOrderTraverse() {
		List<Integer> result = binaryTreeTraversal.preOrderTraverse(BinaryNode.simpleTree);
		List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
		Assert.assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void inOrderTraverse() {
		List<Integer> result = binaryTreeTraversal.inOrderTraverse(BinaryNode.simpleTree);
		List<Integer> expected = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
		Assert.assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void postOrderTraverse() {
		List<Integer> result = binaryTreeTraversal.postOrderTraverse(BinaryNode.simpleTree);
		List<Integer> expected = Arrays.asList(4, 5, 2, 6, 7, 3, 1);
		Assert.assertArrayEquals(expected.toArray(), result.toArray());
	}

	@Test
	public void breadthFirstTraverse() {
		List<Integer> result = binaryTreeTraversal.breadthFirstTraverse(BinaryNode.simpleTree);
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Assert.assertArrayEquals(expected.toArray(), result.toArray());
	}

}
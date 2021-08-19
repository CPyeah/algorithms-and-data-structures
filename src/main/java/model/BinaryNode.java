package model;

public class BinaryNode {

	public int val;
	public BinaryNode left;
	public BinaryNode right;

	public static BinaryNode simpleTree = of();

	BinaryNode(int val) {
		this.val = val;
	}

	/**
	 *           1
	 *         /   \
	 *        2    3
	 *       / \  / \
	 *      4  5 6   7
	 *
	 * @return root node
	 */
	public static BinaryNode of() {
		BinaryNode node1 = new BinaryNode(1);
		BinaryNode node2 = new BinaryNode(2);
		BinaryNode node3 = new BinaryNode(3);
		BinaryNode node4 = new BinaryNode(4);
		BinaryNode node5 = new BinaryNode(5);
		BinaryNode node6 = new BinaryNode(6);
		BinaryNode node7 = new BinaryNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		return node1;
	}

	@Override
	public String toString() {
		return "BinaryNode{" + val + '}';
	}
}

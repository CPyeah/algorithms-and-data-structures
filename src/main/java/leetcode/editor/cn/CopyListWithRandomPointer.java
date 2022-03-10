package leetcode.editor.cn;

/**
 * [138] 复制带随机指针的链表
 */
public class CopyListWithRandomPointer {

	//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

	class Solution {

		public Node copyRandomList(Node head) {
			if (head == null) {
				return null;
			}
			Node pointer = head;
			// 复制
			while (pointer != null) {
				Node copy = copyNode(pointer);
				copy.next = pointer.next;
				pointer.next = copy;
				pointer = pointer.next.next;
			}
			// a -> a' -> b -> b' -> c -> c'

			// 处理random
			pointer = head;
			while (pointer != null) {
				if (pointer.random != null) {
					pointer.next.random = pointer.random.next;
				}
				pointer = pointer.next.next;
			}

			// 拆分  一个一个拆  当前节点的next 指向下下个节点
			Node cloneHead = head.next;
			pointer = head;
			while (pointer.next != null) {
				Node temp = pointer.next;
				pointer.next = pointer.next.next;
				pointer = temp;
			}

			return cloneHead;
		}

		private Node copyNode(Node pointer) {
			return new Node(pointer.val);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	class Node {

		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

}
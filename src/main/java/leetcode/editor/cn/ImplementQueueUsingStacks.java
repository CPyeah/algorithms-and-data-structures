package leetcode.editor.cn;

import java.util.Stack;

/**
 * [232] 用栈实现队列
 */
public class ImplementQueueUsingStacks {

	//leetcode submit region begin(Prohibit modification and deletion)
	class MyQueue {

		// 两个栈 来回倒腾数据
		private Stack<Integer> inStack = new Stack<>();
		private Stack<Integer> outStack = new Stack<>();

		public MyQueue() {

		}

		public void push(int x) {
			transfer(outStack, inStack);
			inStack.push(x);
		}

		private void transfer(Stack<Integer> originStack, Stack<Integer> destStack) {
			while (!originStack.isEmpty()) {
				destStack.push(originStack.pop());
			}
		}

		public int pop() {
			transfer(inStack, outStack);
			return outStack.pop();
		}

		public int peek() {
			transfer(inStack, outStack);
			return outStack.peek();
		}

		public boolean empty() {
			return inStack.isEmpty() && outStack.isEmpty();
		}
	}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn.sort;

/**
 * 堆排序
 * <p>
 * https://segmentfault.com/a/1190000013960582
 */
public class HeapSort {

	/**
	 * 1. 把数组抽象成二叉树 2. 每个子树做堆化操作，比较根元素和子元素，交换位置，保持根元素最大 3. 循环，保持整棵树的根元素最大 4. 把根元素放到最后
	 */
	public static class Solution {

		// 7  6  5  2  3  4  1
		//          7
		//         /  \
		//        5    2
		//       / \  /
		//      3  4  1
		//  左边叶子节点的位置 = 根节点的位置 * 2 + 1
		//  右边叶子节点的位置 = 根节点的位置 * 2 + 2
		public int[] sort(int[] nums) {
			for (int i = nums.length - 1; i >= 0; i--) {
				// 堆化
				heapify(nums, i);
				// 此时root已经最大，把root移动到后面
				SortUtil.swap(nums, 0, i);

			}
			return nums;
		}

		// 从后往前比较每一个节点
		// 类似一个冒泡的过程，把最大的值给冒上来
		private void heapify(int[] nums, int i) {
			for (int j = i; j >= 0; j--) {
				checkRootValueBeMax(nums, j, i);
			}
		}

		private void checkRootValueBeMax(int[] nums, int rootIndex, int limit) {
			int leftIndex = rootIndex * 2 + 1;
			int rightIndex = rootIndex * 2 + 2;
//			int maxValueIndex = rootIndex;
//
//			if (leftIndex < limit && nums[leftIndex] > nums[maxValueIndex]) {
//				maxValueIndex = leftIndex;
//			}
//			if (rightIndex < limit && nums[rightIndex] > nums[maxValueIndex]) {
//				maxValueIndex = rightIndex;
//			}
//			if (maxValueIndex != rootIndex) {
//				SortUtil.swap(nums, maxValueIndex, rootIndex);
//				checkRootValueBeMax(nums, maxValueIndex, limit);
//			}


			if (leftIndex < limit && nums[leftIndex] > nums[rootIndex]) {
				SortUtil.swap(nums, leftIndex, rootIndex);
			}
			if (rightIndex < limit && nums[rightIndex] > nums[rootIndex]) {
				SortUtil.swap(nums, rightIndex, rootIndex);
			}
			if (leftIndex < nums.length &&
					rightIndex < nums.length &&
					nums[leftIndex] > nums[rightIndex]) {
				SortUtil.swap(nums, leftIndex, rightIndex);
			}
		}
	}

}
